package com.abstractart;

public class Sculpture extends Art {
	protected String material;
	//constructor
	public Sculpture(String title,String author, String description, String material) {
		this.title = title;
		this.author = author;
		this.description = description;
		this.material = material;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public void viewArt() {		
		System.out.println(this.getTitle());
		System.out.println(this.getAuthor());
		System.out.println(this.getDescription());
		System.out.println(this.getMaterial());
	}
}

