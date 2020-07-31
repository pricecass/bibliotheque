package com.nolan.bibliotheque.api.book;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.nolan.bibliotheque.api.category.Category;
import com.nolan.bibliotheque.api.loan.Loan;


@Entity
@Table(name = "BOOKS")
public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookID;
	
	private String isbn;
	private String title;
	private String author;
	private String publishingHouse;
	private int editionVersion;
	private int copyNumber;
	
	@ManyToOne(optional = false) 
	@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "categoryID")
	private Category category;
	
	@OneToMany(mappedBy = "loanBookCustomer.book",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private Set<Loan> loans = new HashSet<Loan>();
	
	public Book() {}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public int getEditionVersion() {
		return editionVersion;
	}

	public void setEditionVersion(int editionVersion) {
		this.editionVersion = editionVersion;
	}

	public int getCopyNumber() {
		return copyNumber;
	}

	public void setCopyNumber(int copyNumber) {
		this.copyNumber = copyNumber;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Loan> getLoans() {
		return loans;
	}

	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", isbn=" + isbn + ", title=" + title + ", author=" + author
				+ ", publishingHouse=" + publishingHouse + ", editionVersion=" + editionVersion + ", copyNumber="
				+ copyNumber + ", category=" + category + ", loans=" + loans + "]";
	}

}