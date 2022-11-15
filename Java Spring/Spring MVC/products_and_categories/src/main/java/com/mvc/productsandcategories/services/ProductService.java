package com.mvc.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mvc.productsandcategories.models.Category;
import com.mvc.productsandcategories.models.Product;
import com.mvc.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	//Create new product
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	//Read(retrieve) a product from database
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}

	// Update product
	public void updateProduct(Product product) {
		productRepository.save(product);
	}

	public List<Product> getProductsNotOfCategory(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
