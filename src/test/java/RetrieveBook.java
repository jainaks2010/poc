import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

import com.zensar.poc.Library;
import com.zensar.poc.data.Book;
import com.zensar.poc.exceptions.BookNotFoundException;
import com.zensar.poc.exceptions.InvalidBookException;
import com.zensar.poc.service.BookService;


public class RetrieveBook {
	
	private static  BookService bookService;
	private static  Book javabook;
	private static  Book fictionBook;
	
	@BeforeClass
	public static void init() throws InvalidBookException{
		bookService = Library.getInstance().getBookService();
		javabook =new Book("Head First Java","Kathy Sierra",600,Book.Category.COMPUTER);
		boolean iSusccessful = bookService.addBook(javabook);
		assertTrue(iSusccessful);
		fictionBook = new Book("Five point someone", "Chetan Bhagat", 100, Book.Category.FICTION);
		iSusccessful = bookService.addBook(fictionBook);
		assertTrue(iSusccessful);
	}
		
	@Test
	public void testGetAllBooks(){
		Collection<Book> books = bookService.findAllBooks();
		assertTrue("Books size in library must be more than zero",books.size()>0);
		for (Book book : books) {
			assertNotNull(book.getName(), "Name must not be null");
			assertNotNull(book.getAuthor(), "Author must not be null");
			assertTrue("price must be more than zero", book.getPrice() >= 0);
		}
	}
	
	@Test
	public void findValidBookByName() throws InvalidBookException{
		Book bookSaved=bookService.findBookByName("Head First Java");
		assertTrue("Book retrieved and book saved must be same", bookSaved.equals(javabook));
	}
	
	@Test(expected = BookNotFoundException.class)
	public void findInValidBookByName() throws BookNotFoundException{
		Book bookSaved=bookService.findBookByName(" The elements of Java style");
		assertTrue("Book retrieved and book saved must be same", bookSaved.equals(javabook));
	}
	

}
