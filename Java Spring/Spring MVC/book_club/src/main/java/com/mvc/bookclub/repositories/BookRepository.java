package com.mvc.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.bookclub.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	//	---- Retrieves all books -------------------------------
	List<Book> findAll();
}