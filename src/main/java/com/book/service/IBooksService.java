package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.book.model.Book;


public interface IBooksService {

	public List<Book> getAllBooks();
	
	Optional <Book> getbookbyid(Integer id);

	public List<Book> getAllBooksByAuthorId(Integer id);

	Integer saveBook2(Book book);
	
	public List<Book> searcBooks(String category, String authorName, double price);

	List<Book> searcBooksbyCategory(String category);
	
	
	List<Book>  searcBooksbyAuthorname(String authorName);
	
	List<Book>  searcBooksbyPublisherName(String publisherName);
	
	
}
