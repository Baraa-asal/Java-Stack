package com.mvc.languages.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mvc.languages.models.Language;
import com.mvc.languages.repositories.LanguageRepository;


@Service
public class LanguageService {
	//dependency injection for the repository here : 
	private final LanguageRepository langRepo;
	
	//Constructor:
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}

	//a method that returns all the expenses:
	public List<Language> allLanguages(){
		//i need to cast it or just put it in repository.
		return (List<Language>) langRepo.findAll();
	}
	
	// a method that creates a new expense
	public Language createLanguage(Language expense) {
		return langRepo.save(expense);
	}
	
	//a method that retrieves(reads) an expense:
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = langRepo.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}
		return null;
	}
	
	//a method that updates an expense:
	public Language updateLanguage(Language expense) {
		return langRepo.save(expense);
	}
	
	//a method that deletes an expense:
	public void deleteLanguage(Long id) {
		langRepo.deleteById(id);
	}

}
