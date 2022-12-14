package com.book.model;

import java.io.File;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bookId;
	private Integer authorId;
	private String logo;
	private String title;
	private String category;
	private Double price;
	private String authorname;
	private String publisher;
	private Date publishedDate;
	private String content;
	private boolean Active;
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean getActive() {
		return Active;
	}
	public void setActive(boolean active) {
		Active = active;
	}
	public Book(Integer bookId, Integer authorId, String logo, String title, String category, Double price,
			String authorname, String publisher,  String content, boolean active) {
		super();
		this.bookId = bookId;
		this.authorId = authorId;
		this.logo = logo;
		this.title = title;
		this.category = category;
		this.price = price;
		this.authorname = authorname;
		this.publisher = publisher;
	this.publishedDate = publishedDate;
		this.content = content;
		Active = active;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
}
