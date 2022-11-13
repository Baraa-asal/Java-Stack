package com.mvc.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.bookclub.models.Book;
import com.mvc.bookclub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;

	public Book create(Book book) {
		return this.bookRepo.save(book);
	}

	public List<Book> retrieveAll() {
		return this.bookRepo.findAll();
	}

	public Book retrieveBook(Long id) {
		Optional<Book> optBook = bookRepo.findById(id);
		if (optBook.isPresent()) {
			Book book = optBook.get();
			return book;
		}
		return null;
	}

	public Book update(Book book) {
		Optional<Book> optBook = bookRepo.findById(book.getId());
		if (optBook.isPresent()) {
			return bookRepo.save(book);
		}
		return null;

	}

	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
}