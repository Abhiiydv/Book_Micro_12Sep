package com.book.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer authorId;
	
	private String authorName;
	
	private String authorEmail;

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public Author(Integer authorId, String authorName, String authorEmail) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorEmail = authorEmail;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
