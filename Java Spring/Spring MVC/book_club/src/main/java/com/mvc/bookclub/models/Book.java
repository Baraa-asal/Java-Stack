package com.mvc.bookclub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {

	//	//// FIELDS //////////////////////////////////////////
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=1, max=100, message="Title must be one to one hundred characters in length")
	private String title;
	
	@NotNull
	@Size(min=1, max=55, message="Title must be one to fifty-five characters in length")
	private String author;
	
	@NotNull
	@Size(min=1, max=255, message="Thoughts must be one to two hundred fifty-five characters in length")
	private String myThoughts;
	
	///////////////Connecting book to user, many books for one user/////////////////
	//many-to-one relationship:
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name="user_id" )
	private User user;
	
	@Column(updatable=false)		
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate()	{
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	

	public Book() {}

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMyThoughts() {
		return myThoughts;
	}

	public void setMyThoughts(String myThoughts) {
		this.myThoughts = myThoughts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}