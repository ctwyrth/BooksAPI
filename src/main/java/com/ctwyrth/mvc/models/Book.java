package com.ctwyrth.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {
	//-------------------ATTRIBUTES-------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 2, max = 200, message="Title must be at least 2 characters.")
	private String title;
	
	@NotNull
	@Size(min = 5, max = 200, message="Description must be at least 5 characters.")
	private String description;
	
	@NotNull
	@Size(min = 3, max = 40, message="Language must be at least 3 characters.")
	private String language;
	
	@NotNull
	@Min(value=100, message="Must be at least 100 pages.")
	private Integer numberOfPages;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	//--------------------CONTRUCTORS-------------------
	public Book() {}
	public Book(String title, String description, String lang, Integer pages) {
		this.title = title;
		this.description = description;
		this.language = lang;
		this.numberOfPages = pages;
	}
	
	//-------------------METHODS-------------------
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	//-------------------GETTERS & SETTERS-------------------
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public Integer getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
}
