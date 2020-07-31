package com.nolan.bibliotheque.api.category;

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
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		return categoryService.findAll();
	}
	
	@GetMapping("/category/{cat-id}")
	public Category getCategoryById(@PathVariable("cat-id") Long id) {
		return categoryService.findById(id);
	}
	
	@PostMapping("/save-category")
	public Category saveCategory(@RequestBody Category category) {
		return categoryService.save(category);
	}

	@PutMapping("/update-category")
	public Category updateCategory(@RequestBody Category category) {
		return categoryService.update(category);
	}
	
	@DeleteMapping("/delete-category/{cat-id}")
	public void deleteCategoryById(@PathVariable("cat-id") Long id) {
		categoryService.deleteById(id);
	}
}
