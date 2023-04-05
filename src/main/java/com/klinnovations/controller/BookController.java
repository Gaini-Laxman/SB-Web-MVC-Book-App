package com.klinnovations.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.klinnovations.entity.Book;
import com.klinnovations.repo.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repo;

	@GetMapping("/book")
	  //public ModelAndView getBookById(@RequestParam("id") Integer id) {
		public String getBookById(@RequestParam("id") Integer id, Model model) {

		//System.out.println("Id ::" + id);
		//ModelAndView mav = new ModelAndView();

		Optional<Book> findById = repo.findById(id);
		if (findById.isPresent()) {
			Book bookObj = findById.get();
			model.addAttribute("book", bookObj);

			//System.out.println(bookObj);
			// Sending data to view
			//mav.addObject("book", bookObj);
		}

		// Setting view page Name
		//mav.setViewName("index");

		return "index";
	}

}






