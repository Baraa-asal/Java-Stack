package com.daikichi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Controller
public class HelloHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}
	
	@RequestMapping("/") 
	public String index(Model model) {
		model.addAttribute("fruit", "banana");
		return "index.jsp";
	}
	
	@RequestMapping("/name")
	public String index(@RequestParam(value="name", required=false) String parameter1){
		if(parameter1 == null) {
			return "You searched for: nothing";
		}
		else {
			return "You searched for: " + parameter1;
		}
	}
	
}
