package com.nolan.bibliotheque.api.loan;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.nolan.bibliotheque.api.book.Book;
import com.nolan.bibliotheque.api.customer.Customer;

@Embeddable
public class LoanBookCustomer implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Book book;
	
	@ManyToOne
	private Customer customer;
	
	private LocalDate createdAt = LocalDateTime.now().toLocalDate();;
	
	public LoanBookCustomer() {}

	public LoanBookCustomer(Book book, Customer customer) {
		this.book = book;
		this.customer = customer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	
}
