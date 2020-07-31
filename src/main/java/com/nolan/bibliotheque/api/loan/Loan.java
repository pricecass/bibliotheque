package com.nolan.bibliotheque.api.loan;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "LOANS")
@AssociationOverrides({
@AssociationOverride(name = "loanBookCustomer.book", joinColumns = @JoinColumn(name = "bookID")),
@AssociationOverride(name = "loanBookCustomer.customer", joinColumns = @JoinColumn(name = "customerID"))
})
public class Loan implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LoanBookCustomer loanBookCustomer = new LoanBookCustomer();
	
	private LocalDate startedAt = LocalDateTime.now().toLocalDate();
	
	private LocalDate finishedAt;
	
	@Enumerated(EnumType.STRING)
	private LoanStatus status;

	public LoanBookCustomer getLoanBookCustomer() {
		return loanBookCustomer;
	}

	public void setLoanBookCustomer(LoanBookCustomer lbc) {
		this.loanBookCustomer = lbc;
	}

	public LocalDate getStartedAt() {
		return startedAt;
	}

	public void setSratedAt(LocalDate startedAt) {
		this.startedAt = startedAt;
	}

	public LocalDate getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(LocalDate finishedAt) {
		this.finishedAt = finishedAt;
	}

	public LoanStatus getStatus() {
		return status;
	}

	public void setStatus(LoanStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loanBookCustomer == null) ? 0 : loanBookCustomer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		if (loanBookCustomer == null) {
			if (other.loanBookCustomer != null)
				return false;
		} else if (!loanBookCustomer.equals(other.loanBookCustomer))
			return false;
		return true;
	}
	
}
