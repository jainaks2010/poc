package com.zensar.poc.service;

import java.util.Collection;

import com.zensar.poc.data.Book;
import com.zensar.poc.data.BookDAO;
import com.zensar.poc.exceptions.BookNotFoundException;
import com.zensar.poc.exceptions.InvalidBookException;

public class BookService {
	
	BookDAO bookDAO = new BookDAO();

	public boolean addBook(Book book) throws InvalidBookException {
		return bookDAO.addBook(book);
	}

	public Collection<Book> findAllBooks() {
		return bookDAO.findAllBooks();
	}

	public Book findBookByName(String bookName) throws BookNotFoundException {
		Book requiredBook =null;
		Collection<Book> books = findAllBooks();
		for (Book book : books) {
			if(book.getName().equals(bookName)){
				requiredBook = book;
				break;
			}
		}
		if(requiredBook == null){
			throw new BookNotFoundException("Book not found in the library");
		}
		return requiredBook;
	}

}
