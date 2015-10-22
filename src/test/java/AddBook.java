import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.zensar.poc.Library;
import com.zensar.poc.data.Book;
import com.zensar.poc.exceptions.InvalidBookException;
import com.zensar.poc.service.BookService;


public class AddBook {
	
	private static BookService bookService;
	private  Book book;
	
	@BeforeClass
	public static void init(){
		bookService = Library.getInstance().getBookService();
	}
	
	@Before
	public void setUp() throws InvalidBookException{
		book =new Book("Java SE Certification","Khalid Mughal",600,Book.Category.COMPUTER);
	}
	
	@Test
	public void addBook() throws InvalidBookException {
		boolean isSuccessful = bookService.addBook(book);
		assertTrue("Book must be added", isSuccessful);
	}
	
	@Test(expected = InvalidBookException.class)
	public void testInvalidBookTitle() throws InvalidBookException{
		Book book = new Book(null,"Khalid Mughal",0,Book.Category.COMPUTER);
	}

	
	@Test(expected = InvalidBookException.class)
	public void testInvalidBookPrice() throws InvalidBookException{
		Book book = new Book("Java SE Certification","Khalid Mughal",0,Book.Category.COMPUTER);
	}
	
	@Test
	public void testDuplicateBook() throws InvalidBookException {
		boolean isSuccessful = bookService.addBook(book);
		assertFalse("Duplicate books must NOT be added", isSuccessful);
	}
}
