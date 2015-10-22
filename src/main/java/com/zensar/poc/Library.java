package com.zensar.poc;

import com.zensar.poc.service.BookService;

public class Library {
	
	private BookService bookService = new BookService();
	
	private static Library library = new Library();
	
	private Library(){}
	
	public static Library getInstance(){
		return library;
	}

	public BookService getBookService() {
		return bookService;
	}
	


}
