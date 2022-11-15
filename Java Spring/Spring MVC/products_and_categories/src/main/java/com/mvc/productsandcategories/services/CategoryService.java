package com.mvc.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mvc.productsandcategories.models.Category;
import com.mvc.productsandcategories.models.Product;
import com.mvc.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}

	public List<Category> getCategoriesNotOfProduct(Product product) {
		return categoryRepository.findByProductsNotContains(product);
	}
	
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
}
