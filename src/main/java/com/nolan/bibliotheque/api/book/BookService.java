package com.nolan.bibliotheque.api.book;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

//import com.nolan.bibliotheque.api.category.Category;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	// return the list of books
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	// Return the a book 
	public Book findById(Long bookId) {
		return bookRepository.findById(bookId).get();
	}
	
	// Save a new book and return that
	public Book save(BookDTO bookDTO) {
		return bookRepository.save(mapBookDtoToBook(bookDTO));
	}
	
	// Update a book 
	public Book update(BookDTO bookDTO) {
		return bookRepository.save(mapBookDtoToBook(bookDTO));
	}
	
	// Delete a book category with bookId as parameter
	public void deleteById(Long bookId) {
		bookRepository.deleteById(bookId);
	}
	
	/**
	 * conversion from Book entity to BookDTOThis method uses the 
	 * ModelMapper library for mapping a Book entity to BookDTO
	 * 
	 * @param book
	 * @return bookDTO
	 */
	public BookDTO convertBookToBookDto(Book book) {
		
		ModelMapper modelMapper = new ModelMapper();
		// Map the Book entity to BookDTO
		BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
		
		/*BookDTO bookDTO = new BookDTO();
		bookDTO.setBookID(book.getBookID());
		bookDTO.setAuthor(book.getAuthor());
		bookDTO.setCopyNumber(book.getCopyNumber());
		bookDTO.setEditionVersion(book.getEditionVersion());
		bookDTO.setPublishingHouse(book.getPublishingHouse());
		bookDTO.setIsbn(book.getIsbn());
		bookDTO.setCategoryID(book.getCategory().getCategoryId());*/
		
		return bookDTO;
	}
	
	/**
	 * conversion from BookDTO entity to Book
	 * This method uses the ModelMapper library
	 * for mapping a BookDTO entity to Book
	 * 
	 * @param bookDTO
	 * @return book
	 */
	public Book mapBookDtoToBook(BookDTO bookDTO) {
		
		ModelMapper modelMapper = new ModelMapper();
		// Map the BookDTO entity to Book
		Book book = modelMapper.map(bookDTO, Book.class);
		
		/*Book book = new Book();
		Category category = new Category();
		category.setCategoryId(bookDTO.getCategoryID());
		book.setAuthor(bookDTO.getAuthor());
		book.setCategory(category);
		book.setCopyNumber(bookDTO.getCopyNumber());
		book.setEditionVersion(bookDTO.getEditionVersion());
		book.setIsbn(bookDTO.getIsbn());
		book.setPublishingHouse(bookDTO.getPublishingHouse());
		book.setTitle(bookDTO.getTitle());*/
		
		return book;
	}
	
	// Map a list of Book to BookDTO list
	public List<BookDTO> mapBookToBookDTO(List<Book> books) {
		
		Function<Book, BookDTO> mapper = (book)->{
			BookDTO bookDTO = new BookDTO();
			bookDTO.setBookID(book.getBookID());
			bookDTO.setAuthor(book.getAuthor());
			bookDTO.setCopyNumber(book.getCopyNumber());
			bookDTO.setEditionVersion(book.getEditionVersion());
			bookDTO.setIsbn(book.getIsbn());
			bookDTO.setTitle(book.getTitle());
			bookDTO.setCategoryID(book.getCategory().getCategoryId());
			return bookDTO;
		};
		
		if(!CollectionUtils.isEmpty(books)) {
			return books.stream().map(mapper).sorted().collect(Collectors.toList());
		}
		return null;
	}

}
