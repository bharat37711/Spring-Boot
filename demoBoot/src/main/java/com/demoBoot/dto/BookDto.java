package com.demoBoot.dto;

public class BookDto {

	
 
	private String name;
	
	private String author;

	
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BookDto [name=" + name + ", author=" + author + "]";
	}

	
}
