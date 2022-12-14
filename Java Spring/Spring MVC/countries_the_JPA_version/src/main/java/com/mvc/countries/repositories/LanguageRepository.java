package com.mvc.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mvc.countries.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long>{
	
	@Query("SELECT c.name, l.language, l.percentage FROM Language l JOIN l.country c WHERE l.percentage > 89 ORDER BY l.percentage DESC")
	List<Object[]> languagesPercentGreater89();

}