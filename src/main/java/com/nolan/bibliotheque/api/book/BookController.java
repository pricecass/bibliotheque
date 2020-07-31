package com.nolan.bibliotheque.api.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bibliotheque/api/")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<BookDTO> getAllBooks() {
		return bookService.mapBookToBookDTO(bookService.findAll());
	}
	
	@GetMapping("/book/{book-id}")
	public BookDTO getBookById(@PathVariable("book-id") Long id) {
		return bookService.convertBookToBookDto(bookService.findById(id));
	}
	
	@PostMapping("/save-book")
	public Book saveBook(@RequestBody BookDTO bookDTO) {
		return bookService.save(bookDTO);
	}

	@PutMapping("/update-book")
	public Book updateCategory(@RequestBody BookDTO bookDTO) {
		return bookService.update(bookDTO);
	}
	
	@DeleteMapping("/delete-book/{book-id}")
	public void deleteCategoryById(@PathVariable("book-id") Long id) {
		bookService.deleteById(id);
	}

}
