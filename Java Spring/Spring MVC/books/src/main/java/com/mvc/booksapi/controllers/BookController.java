package com.mvc.booksapi.controllers;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "form.jsp";
    }
    @PostMapping("/books")
    public String create(@Valid @ModelAttribute("book") Book book,BindingResult result ) {
        if (result.hasErrors()) {
            return "form.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
