package com.zensar.poc.data;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import com.zensar.poc.exceptions.InvalidBookException;

public class BookDAO {

	 private static Set<Book> bookshelf = new TreeSet<Book>();
	 
	 public boolean addBook(Book book) throws InvalidBookException{
		 boolean isAdded = false;
		 if(book.getName() != null && book.getAuthor() != null && book.getPrice() >=  0){
			 isAdded = bookshelf.add(book);
		 }else{
			 throw new InvalidBookException("Book name , author must not be null & price must be more than zero");
		 }
		 return isAdded;
	 }

	public Collection<Book> findAllBooks() {
		return bookshelf;
	}
	
}
