package com.zensar.poc.exceptions;


public class BookNotFoundException extends InvalidBookException {

	public BookNotFoundException(String msg) {
		super(msg);
	}

}
