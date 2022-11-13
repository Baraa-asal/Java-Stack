package com.mvc.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mvc.bookclub.models.Book;
import com.mvc.bookclub.models.LoginUser;
import com.mvc.bookclub.models.User;
import com.mvc.bookclub.services.BookService;
import com.mvc.bookclub.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;

	@GetMapping("/")
	public String index(Model model, HttpSession session) {

		if (session.getAttribute("user_id") != null) {
			return "redirect:/books";
		}
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}

	@GetMapping("/books")
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			User loggedInUser = userService.retrieveUserById((Long) session.getAttribute("user_id"));
			model.addAttribute("loggedInUser", loggedInUser);
			//for viewing the books in the main page:
//			List<Book> bookList = bookService.retrieveAll();
//			model.addAttribute("booklist", bookList);
			return "dashboard.jsp";
		}
		return "redirect:/";
	}
///////////////////////////////////////////////////////////////////////////
	@PutMapping("/")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {
		userService.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/books";
	}

	@PostMapping("/")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		User user = userService.login(newLogin, result);
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("user_id", user.getId());
		return "redirect:/books";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////
	@GetMapping("/books/new")
	public String addNewBook() {
		return "newBook.jsp";
	}
	
	
	
	
	
	
	
	
}
