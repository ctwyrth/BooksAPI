package com.ctwyrth.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
    @GetMapping("/books/add")
    public String addBook(@ModelAttribute("book") Book book) {
    	return "/books/new.jsp";
    }
    @PostMapping("/books/add")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
    	if (result.hasErrors()) {
    		return "/books/new.jsp";
    	} else {
    		bookService.createBook(book);
    		return "redirect:/books";
    	}
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
	@GetMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/books/edit.jsp";
    }
    
    @PutMapping("/books/{id}")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
	
	// delete a book
	@GetMapping("/books/delete/{id}")
	public String deleteOneBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}

}
