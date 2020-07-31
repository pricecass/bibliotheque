package com.nolan.bibliotheque.api.loan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LoanRepository extends JpaRepository<Loan, Long> {
	
	public List<Loan> findLoansByStatus(@Param("status") LoanStatus status);
	
	//public Loan findLoanByBookIDAndCustomerID(@Param("bookId") Long bookId, 
			//@Param("customerId") Long customerId);
	
	@Query("SELECT l "
			+" FROM Loan l "
			+" INNER JOIN l.loanBookCustomer.customer c "
			+" WHERE l.status = ?1 "
			+" AND c.email = ?2")
	public List<Loan> findOpenLoansByCustomer(LoanStatus status, String email);
	

}
