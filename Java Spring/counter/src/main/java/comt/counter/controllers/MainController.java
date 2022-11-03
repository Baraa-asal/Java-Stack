package comt.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	
	@RequestMapping("/")
	public String welcome(HttpSession session) {
		session.setAttribute("count", session.getAttribute("count") == null ?
							0 :
							(Integer)session.getAttribute("count") + 1 );
		return "welcome.jsp";
	}
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		int count = (Integer)session.getAttribute("count");
		return "counter.jsp";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:/";
	}
	@RequestMapping("/double_counter")
	public String doubleCounter(HttpSession session) {
		session.setAttribute("count", session.getAttribute("count") == null ?
				0 :
				(Integer)session.getAttribute("count") + 2 );
		return "welcome.jsp";
	}
	
}
