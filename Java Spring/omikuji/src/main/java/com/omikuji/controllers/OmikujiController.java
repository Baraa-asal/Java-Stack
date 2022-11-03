package com.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/omikuji_form";
	}
	
	@RequestMapping("/omikuji_form")
	public String form() {
		return "form.jsp";
	}
	@RequestMapping(value="/form_data", method = RequestMethod.POST)
	
	public String formData(@RequestParam(value="number") Integer number,
						@RequestParam(value="city") String city,
						@RequestParam(value="person") String person,
						@RequestParam(value="hobby") String hobby,
						@RequestParam(value="livingThing") String livingThing,
						@RequestParam(value="message") String message,
						HttpSession session) {
		
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living_thing", livingThing);
		session.setAttribute("message", message);
		
		return "redirect:/show_form";
	}
	
	@RequestMapping("/show_form")
	public String show_form() {
		return "show.jsp";
	}
	
	
}
