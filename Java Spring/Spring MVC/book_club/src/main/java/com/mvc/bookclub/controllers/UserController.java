package com.mvc.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mvc.bookclub.models.Book;
import com.mvc.bookclub.models.LoginUser;
import com.mvc.bookclub.models.User;
import com.mvc.bookclub.repositories.UserRepository;
import com.mvc.bookclub.services.BookService;
import com.mvc.bookclub.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	@Autowired
	private UserRepository userRepository;

	// RENDERING THE LOG REG PAGE:
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			return "redirect:/books";
		}
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	// REGISTER NEW USER:
	@PutMapping("/")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
							BindingResult result, Model model,
							HttpSession session) {
		
		userService.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		//storing the registered user id in session (so it loggs in directly):
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/books";
	}
	
	// LOGIN TO AN EXISTING USER:
	@PostMapping("/")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		User user = userService.login(newLogin, result);
		if (result.hasErrors()) {
			//sending the logged in user to the jsp file if has errors:
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		//if no errors: storing the logged in user id in session, and log in to the dashboard:
		session.setAttribute("user_id", user.getId());
		return "redirect:/books";
	}
	
	//method to log out:
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////// ------methods start from here after LogReg------  //////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////
	// up to here: I have the logged in user ID stored in session "user_id"
	
	
	@GetMapping("/books")
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			
			User loggedInUser = userService.retrieveUserById((Long) session.getAttribute("user_id"));
			
			//sending the loggedIn user that we got from the session to the dashboard: 
			model.addAttribute("loggedInUser", loggedInUser);
			
			// for viewing the books in the main page:
			List<Book> bookList = bookService.retrieveAll();
			model.addAttribute("booklist", bookList);
			///////////
			model.addAttribute("userId", (Long) session.getAttribute("user_id"));
			///////////
			return "dashboard.jsp";
		}
		return "redirect:/";
	}
	
	//method to render the form of adding new book.
	@GetMapping("/books/new")
	public String newBookForm(@ModelAttribute("newBook") Book newBook, Model model, HttpSession session) {
		User loggedInUser = userService.retrieveUserById((Long) session.getAttribute("user_id"));
		model.addAttribute("loggedInUser", loggedInUser);
		return "newBook.jsp";
	}
	
	//it reaches this method after i click on submit of adding new book (create book in data base)
	@PostMapping("/books/new/")
	public String createBook(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
//			model.addAttribute("newBook", newBook);
			return "newBook.jsp";
		}
		bookService.create(newBook);
		return "redirect:/books";
	}
	
	
//	//// BOOKS SHOW ////////////////////////////////////////////
    //	Show information from a Book
    
    //	**** GET: Render book information **************************
    @GetMapping("/books/{id}")
    public String booksId(@PathVariable("id") Long id,
    						Model model, HttpSession session) {
    	//	---- Check if User is Logged In  -----------------------
    	if (session.isNew() || session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	//	---- Get the Log In User -------------------------------
    	User loggedInUser = this.userService.retrieveUser((Long) session.getAttribute("user_id"));
    	model.addAttribute("loggedInUser", loggedInUser);
    	//	---- Get Book specified by ID --------------------------
    	Book book = this.bookService.retrieveBook(id);
    	model.addAttribute("book", book);
    	return "booksid.jsp";
    }
    
//	//// BOOKS EDIT ////////////////////////////////////////////
    //	Edit information from a Book
    
    //	**** GET: Render Edit Form *********************************
    @GetMapping("/books/{id}/edit")
    public String booksIdEdit(@PathVariable("id") Long id,
    							Model model, HttpSession session) {
    	//  ---- Check if User is Logged In  -----------------------
    	if (session.isNew() || session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	//	---- Get the Log In User -------------------------------
    	User loggedInUser = this.userService.retrieveUser((Long) session.getAttribute("user_id"));
    	model.addAttribute("loggedInUser", loggedInUser);
    	//	---- Get Book specified by ID --------------------------
    	Book oldBook = this.bookService.retrieveBook(id);
    	model.addAttribute("oldBook", oldBook);
    	return "booksidedit.jsp";
    }
    
    //	**** PUT: Update Old Book on database *************************
    @PutMapping("/books/{id}/edit")
    public String booksIdEditPutt(@Valid @ModelAttribute("oldBook") Book oldBook,
    		BindingResult result, @PathVariable("id") Long id,
    		Model model, HttpSession session) {
    	// 	---- Check if User is Logged In  ------------------------
    	if (session.isNew() || session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	//	---- Get the Log In User --------------------------------
    	User loggedInUser = this.userService.retrieveUser((Long) session.getAttribute("user_id"));
    	model.addAttribute("loggedInUser", loggedInUser);
    	oldBook.setUser(loggedInUser);
    	if (result.hasErrors()) {
            return "booksidedit.jsp";
        } else {
        	this.bookService.update(oldBook);
            return "redirect:/books/" + oldBook.getId();
        }
    }
	
    //	//// BOOKS DELETE //////////////////////////////////////////
    
    @DeleteMapping("/books/{id}/delete")
    public String booksIdDelete(@PathVariable("id") Long id, Model model) {
    	this.bookService.delete(id);
    	return "redirect:/books";
    }
	

}
