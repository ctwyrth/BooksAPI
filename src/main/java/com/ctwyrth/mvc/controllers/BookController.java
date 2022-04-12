package com.ctwyrth.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ctwyrth.mvc.models.Book;
import com.ctwyrth.mvc.services.BookService;

@Controller
public class BookController {
	// --------------------VARIABLES--------------------
		private final BookService bookService;
	    public BookController(BookService bookService){
	        this.bookService = bookService;
	    }
	
	// display the information of one book found by id
	@GetMapping("/books/{id}")
	public String showOneBookById(@PathVariable long id, Model model) {
		Book bookToShow = bookService.findBook(id);
		model.addAttribute("book", bookToShow);
		return "show.jsp";
	}
	

}
