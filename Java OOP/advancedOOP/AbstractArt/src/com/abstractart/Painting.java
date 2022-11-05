package com.abstractart;

public class Painting extends Art {
	String paintType;

	public void viewArt() {		
		System.out.println(this.getTitle());
		System.out.println(this.getAuthor());
		System.out.println(this.getDescription());
		System.out.println(this.getPaintType());
	}
	//constructor
	public Painting(String title,String author, String description, String paintType) {
		this.title = title;
		this.author = author;
		this.description = description;
		this.paintType = paintType;
	}
	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}
	
} 
