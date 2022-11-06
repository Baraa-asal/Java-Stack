package com.mvc.booksapi.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.mvc.booksapi.models.Book;
import com.mvc.booksapi.repositories.BookRepository;

@Service
public class BookService {
	//Inject our book repository:
	private final BookRepository bookRepo;
	//Dependency injection to have this available for us:
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
    // creates a book 
    public Book createBook(Book b) {
        return bookRepo.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
    	//optional means it could exist or not
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
	 // returns all the books
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

	//updates a book, the repository is responsible to update the book if the id matches
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}

	//the repository finds the book by its id and deletes it if it existed 
	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if ((optionalBook).isPresent()) {
			bookRepo.deleteById(id);
		}			
	}
}
