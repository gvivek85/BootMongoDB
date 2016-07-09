package app.repository;


import app.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

//The MongoRepository provides basic CRUD operation methods and also 
//an API to find all documents in the collection

public interface BookRepository extends MongoRepository<Book, String>{

}