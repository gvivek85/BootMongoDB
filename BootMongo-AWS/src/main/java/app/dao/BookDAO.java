package app.dao;

import java.util.List;

import app.model.Book;

public interface BookDAO {
	
public Book findBook(String bookId);
	
	public Book saveBook(Book book);
	
	public Book updateBook(Book book);
	
	public String deleteBook(String bookId);
	
	public List<Book> findAllBooks();

}
