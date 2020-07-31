package com.nolan.bibliotheque.api.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	// return the list of books categories
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	// Return the a book category
	public Category findById(Long categoryId) {
		return categoryRepository.findById(categoryId).get();
	}
	
	// Save a new book category and return that
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
	
	// Update a book category
	public Category update(Category category) {
		return categoryRepository.save(category);
	}
	
	// Delete a book category with categoryId as parameter
	public void deleteById(Long categoryId) {
		categoryRepository.deleteById(categoryId);
	}

}
