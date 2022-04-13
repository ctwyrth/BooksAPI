package com.ctwyrth.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ctwyrth.mvc.models.Book;
import com.ctwyrth.mvc.services.BookService;

@Controller
public class BookController {
	// --------------------VARIABLES--------------------
	private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    
    // create a book
    @PostMapping("/books/add")
    public String create(
    		@RequestParam(value="title") String title,
			@RequestParam(value="description") String desc,
			@RequestParam(value="language") String lang,
			@RequestParam(value="pages") Integer numOfPages) {
    	Book book = new Book(title, desc, lang, numOfPages);
    	bookService.createBook(book);
    	return "redirect:/books";
    }
	
    // display all the books in db
    @GetMapping("/books")
    public String index(Model model) {
    	List<Book> books = bookService.allBooks();
    	model.addAttribute("books", books);
    	return "/books/index.jsp";
    }
    
	// display the information of one book found by id
	@GetMapping("/books/{id}")
	public String showOneBookById(@PathVariable("id") Long id, Model model) {
		Book bookToShow = bookService.findBook(id);
		model.addAttribute("book", bookToShow);
		return "/books/show.jsp";
	}
	
	// update a book found by id
	
	// delete a book
	@GetMapping("/books/delete/{id}")
	public String deleteOneBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}

}
