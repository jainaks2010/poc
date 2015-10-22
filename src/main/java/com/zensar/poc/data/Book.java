package com.zensar.poc.data;

import com.zensar.poc.exceptions.InvalidBookException;

public class Book implements Comparable<Book> {
	
	private String name;
	
	private String author;
	
	private int price;
	
	private Category category;
	
	public Book() {
	}
	
	public Book(String name, String author, int price, Category category ) throws InvalidBookException {
		if(name == null || author == null || price <= 0){
			throw new InvalidBookException("Name, author and price cannot be null");
		}
		this.name = name;
		this.author = author;
		this.price = price;
		if(category == null){
			
		}
		this.category = category;
	}
	
	public static enum Category {
		 SCIENCE,
		 FICTION,
		 MOTIVATION,
		 COMPUTER,
		 UNKNOWN
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int compareTo(Book anyBook) {
		if(name != null && anyBook != null && anyBook.name != null){
			return name.compareTo(anyBook.name);
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Book){
			Book book =(Book) obj;
			return (this.name.equals(book.name) && 
					this.author.equals(book.author) && 
					this.price == book.price &&
					this.category.name().equals(book.category.name()));
					
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (this.name.hashCode() +  
				this.author.hashCode() + 
				this.price +
				this.category.name().hashCode());
	}
	
	

}
