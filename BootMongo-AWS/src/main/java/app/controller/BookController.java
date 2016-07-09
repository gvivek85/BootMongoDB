package app.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.Book;
import app.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookservice;

	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> createBook(@RequestBody Map<String, Object> bookMap){
		Book book = new Book(bookMap.get("name").toString(),
				bookMap.get("isbn").toString(),
				bookMap.get("author").toString(),
				Integer.parseInt(bookMap.get("pages").toString()));

		Book savedBook = bookservice.saveBook(book);
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "Book created successfully");
		response.put("book", savedBook);
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, value="/{bookId}")
	public Book getBookDetails(@PathVariable("bookId") String bookId){
		return bookservice.findBook(bookId);
	}

	@RequestMapping(method = RequestMethod.PUT, value="/{bookId}")
	public Map<String, Object> editBook(@PathVariable("bookId") String bookId,
			@RequestBody Map<String, Object> bookMap){
		Book book = new Book(bookMap.get("name").toString(),
				bookMap.get("isbn").toString(),
				bookMap.get("author").toString(),
				Integer.parseInt(bookMap.get("pages").toString()));
		book.setId(bookId);

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "Book Updated successfully");
		response.put("book", bookservice.updateBook(book));
		return response;
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{bookId}")
	public Map<String, String> deleteBook(@PathVariable("bookId") String bookId){
		String msg = bookservice.deleteBook(bookId);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", msg);

		return response;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> getAllBooks(){
		List<Book> books = bookservice.findAllBooks();
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("totalBooks", books.size());
		response.put("books", books);
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/healthcheck")
	public String healthCheck(){
		return "Called the war file code";
	}
}