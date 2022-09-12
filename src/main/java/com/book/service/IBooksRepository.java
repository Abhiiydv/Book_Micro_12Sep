package com.book.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.book.model.Book;

public interface IBooksRepository extends JpaRepository <Book, Integer> {

	
	
}
