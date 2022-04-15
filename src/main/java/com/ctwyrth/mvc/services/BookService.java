package com.ctwyrth.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctwyrth.mvc.models.Book;
import com.ctwyrth.mvc.repositories.BookRepository;

@Service
public class BookService {
	// --------------------VARIABLES--------------------
	@Autowired
	private BookRepository bookRepository;
	
	//display all books
	public List<Book> allBooks() {
        return bookRepository.findAll();
    }
	
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    // retrieves a book by id
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    // updates a book
    public Book updateBook(Book b) {
    	return bookRepository.save(b);
    }
    
    // deletes a book by id
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}
