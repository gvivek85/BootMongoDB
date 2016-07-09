package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.BookDAO;
import app.model.Book;

@Service("bookservice")
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDao;

	@Override
	public Book findBook(String bookId) {
		return bookDao.findBook(bookId);
	}

	@Override
	public Book saveBook(Book book) {
		return bookDao.saveBook(book);
	}

	@Override
	public Book updateBook(Book book) {
		return bookDao.updateBook(book);
	}

	@Override
	public String deleteBook(String bookId) {
		return "No of Books Deleted " + bookDao.deleteBook(bookId);
	}

	@Override
	public List<Book> findAllBooks() {
		return bookDao.findAllBooks();
	}

}
