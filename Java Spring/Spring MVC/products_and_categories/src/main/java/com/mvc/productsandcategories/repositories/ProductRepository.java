package com.mvc.productsandcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.productsandcategories.models.Category;
import com.mvc.productsandcategories.models.Product;

@Repository
public interface ProductRepository  extends CrudRepository<Product, Long>{
	List<Product> findAll();
	Optional<Product> findById(Long id);
	void deleteById(Long id);
	List<Product> findByCategoriesNotContains(Category category);
}