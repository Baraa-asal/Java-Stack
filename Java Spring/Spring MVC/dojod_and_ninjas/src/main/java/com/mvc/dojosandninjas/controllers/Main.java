package com.mvc.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.dojosandninjas.models.Dojo;
import com.mvc.dojosandninjas.models.Ninja;
import com.mvc.dojosandninjas.services.DojoService;
import com.mvc.dojosandninjas.services.NinjaService;

@Controller
public class Main {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	
	public Main(DojoService dojoService,NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	

	@GetMapping("/")
	public String index() {
		return "redirect:/dojos-and-ninjas";
	}
	
	@GetMapping("/dojos-and-ninjas")
	public String dashboard() {
		return "home.jsp";
	}
	@GetMapping("/add-new-dojo")
	public String new_dojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	@PostMapping("/add-new-dojo")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		dojoService.create(dojo);
		return "redirect:/add-new-dojo";
	}
	
	@GetMapping("/add-new-ninja")
	public String new_dojo(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.retrieveAll());
		return "newNinja.jsp";
	}
	
	@PostMapping("/add-new-ninja")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		}
		ninjaService.create(ninja);
		return "redirect:/add-new-ninja";
	}
	
	@GetMapping("/dojo/{id}")
	public String dojoTable(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.retrieveDojo(id));
		return "ninjasTable.jsp";
		
	}
	
	
	
}

