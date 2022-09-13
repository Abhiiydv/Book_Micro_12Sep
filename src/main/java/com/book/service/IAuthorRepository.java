package com.book.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.model.Author;

public interface IAuthorRepository extends JpaRepository<Author, Integer> {

}
