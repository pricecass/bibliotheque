package com.nolan.bibliotheque.api.book;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BookDTO implements Comparable<BookDTO>{

	@JsonIgnore
	private Long bookID;
	private String isbn;
	private String title;
	private String author;
	private String publishingHouse;
	private int editionVersion;
	private int copyNumber;
	private Long categoryID;
	
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
	
	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public Long getBookID() {
		return bookID;
	}

	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}

	@Override
	public int compareTo(BookDTO o) {
		return this.title.compareToIgnoreCase(o.getTitle());
	}
}
