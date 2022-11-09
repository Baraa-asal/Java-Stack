package com.mvc.languages.controllers;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mvc.languages.models.Language;
import com.mvc.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/")
	public String dashboard() {
		return "redirect:/languages";
	}
	
	@GetMapping("/languages")
	public String index(@ModelAttribute("language") Language language, Model model) {
		model.addAttribute("languages", languageService.allLanguages());
	 	return "index.jsp";
	}
	@PostMapping("/createLanguage")
	public String addLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("languages", languageService.allLanguages());
            return "index.jsp";
        } else {
		languageService.createLanguage(language);
		return "redirect:/languages";
        }
	}
	//this is a method that renders jsp file because i want to edit an language.
	@GetMapping("/languages/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long id) {
		Language currentLanguage = languageService.findLanguage(id);
		model.addAttribute("currentLanguage", currentLanguage);
		return "editLanguage.jsp";
	}
	@PutMapping("/languages/{id}")
	public String update(@Valid @ModelAttribute("currentLanguage") Language language, BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "editLanguage.jsp";
		}
		System.out.println("hei");
		languageService.updateLanguage(language);
		return "redirect:/";
	}
	@DeleteMapping("/languages/{id}")
    public String destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
	
	@GetMapping("/languages/{id}")
	public String showLanguageDetails(Model model, @PathVariable("id") Long id) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "languageDetails.jsp";
	}
	
}
 