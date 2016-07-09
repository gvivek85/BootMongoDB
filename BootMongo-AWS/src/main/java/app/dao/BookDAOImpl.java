package app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.WriteResult;

import app.model.Book;

@Service("bookDao")
public class BookDAOImpl implements BookDAO {

	@Autowired
	private MongoOperations mongoOps;
	
	@Override
	public Book findBook(String bookId) {
		Query query = new Query(Criteria.where("id").is(bookId));
		return mongoOps.findOne(query, Book.class, "books");
	}

	@Override
	public Book saveBook(Book book) {
		mongoOps.insert(book);
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		mongoOps.save(book);
		return book;
	}

	@Override
	public String deleteBook(String bookId) {
		Query query = new Query(Criteria.where("id").is(bookId));
		WriteResult result = mongoOps.remove(query, Book.class, "books");
		return new String (Integer.toString(result.getN()));
	}

	@Override
	public List<Book> findAllBooks() {
		return mongoOps.findAll(Book.class);
	}

}
