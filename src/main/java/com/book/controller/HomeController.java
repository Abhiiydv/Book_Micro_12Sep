package com.book.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
import org.springframework.web.multipart.MultipartFile;

import com.book.model.Book;
import com.book.service.IBooksService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.thoughtworks.xstream.io.path.Path;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HomeController {

	
	@Autowired
	IBooksService bookservice;
	
	
	@GetMapping("/greet")
	public String greetings() {
		return "Hello Book world!";
	}
	String UPLOADED_FOLDER= "C:\\abhishek";
	@PostMapping("/savebook")
	Integer saveBook(@RequestParam("bookstring") String book, @RequestParam("image")MultipartFile file) throws JsonMappingException,JsonProcessingException{
		
		if(file.isEmpty()) {
			
		}
		try {
			byte[] bytes = file.getBytes();
			java.nio.file.Path path= Paths.get(UPLOADED_FOLDER);
			Files.write(path, bytes);
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		Book bookobj= new ObjectMapper().readValue(book,Book.class);
		bookobj.setLogo(file.getOriginalFilename());
		System.out.println(UPLOADED_FOLDER+"abhishek");
		return bookservice.saveBook2(bookobj);
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
	
		/*
		 * @GetMapping("/search") public List<Book>
		 * searchBooks(@RequestParam("category") String category,
		 * 
		 * @RequestParam("authorName") String authorName,
		 * 
		 * @RequestParam("price") Double price){ return
		 * bookservice.searcBooks(category,authorName,price); }
		 */
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
