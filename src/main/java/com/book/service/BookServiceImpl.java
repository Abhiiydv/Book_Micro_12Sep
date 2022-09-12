package com.book.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.model.Book;

@Service
public class BookServiceImpl implements IBooksService{

	@Autowired
	private IBooksRepository booksRepository;

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		
		return booksRepository.findAll();
	}

	@Override
	public Optional<Book> getbookbyid(Integer id) {
		// TODO Auto-generated method stub
		return booksRepository.findById(id);
	}

	@Override
	public List<Book> getAllBooksByAuthorId(Integer id) {
		// TODO Auto-generated method stub
		List<Book> li2=  booksRepository.findAll().stream().filter(a-> a.getAuthorId()==id).collect(Collectors.toList());
	
	       return li2;
	}

	@Override
	public
	 Integer saveBook2(Book book) {
		Book savedBook =  booksRepository.save(book);
		return savedBook.getBookId();
	}

	@Override
	public List<Book> searcBooks(String category, String authorName, double price) {
		// TODO Auto-generated method stub
		List<Book> list = booksRepository.findAll();
		return list.stream().filter(b-> b.getAuthorname().equalsIgnoreCase(authorName)||
				b.getCategory().equalsIgnoreCase(category)||b.getPrice().equals(price)).collect(Collectors.toList());
		
	}

	@Override
	public List<Book> searcBooksbyCategory(String category) {
		// TODO Auto-generated method stub
		List<Book> lis = booksRepository.findAll();
		return lis.stream().filter(a->a.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
		
	}
	@Override
	public List<Book> searcBooksbyAuthorname(String authorName) {
		// TODO Auto-generated method stub
		List<Book> lis = booksRepository.findAll();
		return lis.stream().filter(a->a.getAuthorname().equalsIgnoreCase(authorName)).collect(Collectors.toList());
		
	}

	@Override
	public List<Book> searcBooksbyPublisherName(String publisherName) {
		// TODO Auto-generated method stub
		List<Book> liss = booksRepository.findAll();
		return liss.stream().filter(p->p.getPublisher().equalsIgnoreCase(publisherName)).collect(Collectors.toList());
	}

	
	
	

}