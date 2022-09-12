package com.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.Book;
import com.book.service.IBooksService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HomeController {

	
	@Autowired
	IBooksService bookservice;
	
	
	@GetMapping("/greet")
	public String greetings() {
		return "Hello Book world!";
	}
	
	@PostMapping("/savebook")
	Integer saveBook(@RequestBody Book booki)
	{
		Integer id = bookservice.saveBook2(booki);
		return id;
	}
	@GetMapping("/books") 
	public List<Book> getAllBooks(){
		return bookservice.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public Optional<Book> getbookbyid(@PathVariable Integer id){
			Optional<Book> au =  bookservice.getbookbyid(id);
			return au;
			
		}
	@GetMapping("/books/authors/{id}")
	public List<Book>  getbooksbyAuthorid(@PathVariable Integer id){
			return bookservice.getAllBooksByAuthorId(id);	
		}
	
	@GetMapping("/search")
	public List<Book> searchBooks(@RequestParam("category") String category,
			@RequestParam("authorName") String authorName, 
			@RequestParam("price") Double price){
		return bookservice.searcBooks(category,authorName,price);
	}
	@GetMapping("/books/category/{category}")
	public List<Book> searchBooks(@RequestParam("category") String category){
		return bookservice.searcBooksbyCategory(category);
	}
	@GetMapping("/books/author/{authorName}")
	public List<Book> searchBooks2(@RequestParam("authorName") String authorName){
		return bookservice.searcBooksbyAuthorname(authorName);
	}
	@GetMapping("/books/publisher/{publisherName}")
	public List<Book> searchBooks3(@RequestParam("publisherName") String publisherName){
		return bookservice.searcBooksbyPublisherName(publisherName);
	}
	
	
	
}
