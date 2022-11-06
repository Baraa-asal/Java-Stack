package com.mvc.booksapi.controllers;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mvc.booksapi.models.Book;
import com.mvc.booksapi.services.BookService;

@Controller //responds by rendering jsp pages
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public String index(Model model) {
		ArrayList<Book> books = (ArrayList<Book>) bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	@GetMapping("/books/{bookId}")
	public String showBook(Model model, @PathVariable("bookId") Long id) {
		Book book = bookService.findBook(id);
		
		model.addAttribute("book", book);
		return "showBook.jsp";
	}
}
