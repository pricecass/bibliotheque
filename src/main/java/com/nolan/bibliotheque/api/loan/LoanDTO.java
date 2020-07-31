package com.nolan.bibliotheque.api.loan;

import java.time.LocalDate;

import com.nolan.bibliotheque.api.book.BookDTO;
import com.nolan.bibliotheque.api.customer.CustomerDTO;

public class LoanDTO implements Comparable<LoanDTO>{

	private BookDTO bookDTO = new BookDTO();
	
	private CustomerDTO customerDTO = new CustomerDTO();
	
	private LocalDate startedAt;
	
	private LocalDate finishedAt;

	public BookDTO getBookDTO() {
		return bookDTO;
	}

	public void setBookDTO(BookDTO bookDTO) {
		this.bookDTO = bookDTO;
	}

	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}

	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}

	public LocalDate getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(LocalDate startedAt) {
		this.startedAt = startedAt;
	}

	public LocalDate getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(LocalDate finishedAt) {
		this.finishedAt = finishedAt;
	}

	@Override
	public int compareTo(LoanDTO o) {
		return o.getStartedAt().compareTo(this.startedAt);
	}

	
}
