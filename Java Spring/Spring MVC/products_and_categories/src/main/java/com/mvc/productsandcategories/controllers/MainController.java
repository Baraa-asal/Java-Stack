package com.mvc.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.productsandcategories.models.Category;
import com.mvc.productsandcategories.models.Product;
import com.mvc.productsandcategories.repositories.CategoryRepository;
import com.mvc.productsandcategories.repositories.ProductRepository;
import com.mvc.productsandcategories.services.CategoryService;
import com.mvc.productsandcategories.services.ProductService;

@Controller
public class MainController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	CategoryRepository categoryRepo;
	@Autowired
	ProductRepository productRepo;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("categories", categoryService.getAllCategories());
		return "index.jsp";
	}

	@GetMapping("/products/new")
	public String newProductForm(@ModelAttribute("product") Product product) {
		return "newProductForm.jsp";
	}

	@GetMapping("/categories/new")
	public String newCategoryForm(@ModelAttribute("category") Category category) {
		return "newCategoryForm.jsp";
	}

	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "newProductForm.jsp";
		}
		productService.createProduct(product);
		return "redirect:/";
	}

	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "newProductForm.jsp";
		}
		categoryService.createCategory(category);
		return "redirect:/";
	}

	@GetMapping("products/{id}")
	public String productDetails(@PathVariable("id") Long productID, Model model) {
		Product product = productService.findProduct(productID);
		model.addAttribute("product", product);
		model.addAttribute("categoriesAvailable", categoryService.getCategoriesNotOfProduct(product));
		return "productDetails.jsp";
	}
	
	// ----------- METHOD TO RENDER A CATEGORY DETAILS PAGE ------------

	@GetMapping("categories/{id}")
	public String categoryDetails(@PathVariable("id") Long categoryID, Model model) {
		model.addAttribute("category", categoryService.findCategory(categoryID));
		model.addAttribute("productsAvailable",
				productService.getProductsNotOfCategory(categoryService.findCategory(categoryID)));
		return "categoryDetails.jsp";
	}

	//  ----------- METHOD TO ADD A CATEGORY TO A PRODUCT ----------- 
	
	@PostMapping("products/{id}")
	public String addCategoryToProduct(@RequestParam("selectedCategory") Long selectedCategoryID,
			@PathVariable("id") Long productID) {
		Category thisCategory = categoryService.findCategory(selectedCategoryID);
		Product thisProduct = productService.findProduct(productID);
		thisProduct.getCategories().add(thisCategory);
		productRepo.save(thisProduct);
		return "redirect:/products/" + productID;
	}

	// ----------- METHOD TO REMOVE A CATEGORY RELATED TO A PRODUCT! I'M HAPPY I DID THIS.
	
	@GetMapping("/deleteCategory/{productId}/{categoryId}")
	public String removeCategoryFromProduct(@PathVariable("productId") Long productID,
			@PathVariable("categoryId") Long categoryID) {
		Category thisCategory = categoryService.findCategory(categoryID);
		Product thisProduct = productService.findProduct(productID);
		thisProduct.getCategories().remove(thisCategory);
		productRepo.save(thisProduct);
		return "redirect:/products/" + productID;
	}
	
	//  ----------- METHOD TO ADD A PRODUCT TO A CATEGORY
	
	@PostMapping("categories/{id}")
	public String addProductToCategory(@RequestParam("selectedProduct") Long selectedProductID,
			@PathVariable("id") Long categoryID) {
		Category thisCategory = categoryService.findCategory(categoryID);
		Product thisProduct = productService.findProduct(selectedProductID);
		thisCategory.getProducts().add(thisProduct);
		categoryRepo.save(thisCategory);
		return "redirect:/categories/" + categoryID;
	}
	
	//  ----------- METHOD TO REMOVE A PRODUCT RELATED TO A CATEGORY! I'M HAPPY I DID THIS.
	
	@GetMapping("/deleteProduct/{categoryId}/{productId}")
	public String removeProductFromCategory(@PathVariable("categoryId") Long categoryID, @PathVariable("productId") Long productID) {
		Category thisCategory = categoryService.findCategory(categoryID);
		Product thisProduct = productService.findProduct(productID);
		thisProduct.getCategories().remove(thisCategory);
		productRepo.save(thisProduct);
		return "redirect:/categories/" + categoryID;
	}
	
	//  ----------- METHOD TO RENDER A PAGE THAT EDITS A PRODUCT
	
	@GetMapping("/products/{productId}/edit")
	public String editProduct_page(Model model, @PathVariable("productId") Long productID) {
		Product currentProduct = productService.findProduct(productID);
		model.addAttribute("currentProduct", currentProduct);
		return "editProduct.jsp";
	}
	
	//  ----------- METHOD TO ACTUALLY UPDATE A PRODUCT INFO:
	
	@PutMapping("/products/{id}")
	public String updateProductInfo(@Valid @ModelAttribute("currentProduct") Product product, BindingResult result, @PathVariable("id") Long productID) {
		if (result.hasErrors()) {
			return "editProduct.jsp";
		}
		productService.updateProduct(product);
		return "redirect:/products/" + productID ;
	}

	//  ----------- METHOD TO RENDER A PAGE THAT EDITS A CATEGORY
	
	@GetMapping("/categories/{categoryId}/edit")
	public String editCategory_page(Model model, @PathVariable("categoryId") Long categoryID) {
		Category currentCategory = categoryService.findCategory(categoryID);
		model.addAttribute("currentCategory", currentCategory);
		return "editCategory.jsp";
	}
	
	//  ----------- METHOD TO ACTUALLY UPDATE A CATEGORY INFO:
	
	@PutMapping("/categories/{id}")
	public String updateCategoryInfo(@Valid @ModelAttribute("currentCategory") Category category, BindingResult result, @PathVariable("id") Long categoryID) {
		if (result.hasErrors()) {
			return "editCategory.jsp";
		}
		categoryService.updateCategory(category);
		return "redirect:/categories/" + categoryID ;
	}
	
	//  ----------- METHOD TO DELETE A PRODUCT
	
	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return "redirect:/";
	}
	
	//  ----------- METHOD TO DELETE A CATEGORY
	
	@DeleteMapping("/categories/{id}")
	public String deleteCategories(@PathVariable("id") Long id) {
		categoryService.deleteCategory(id);
		return "redirect:/";
	}
}
