package com.mvc.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mvc.countries.models.Country;

public interface CountryRepository extends CrudRepository<Country, Long>{
	
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language = 'Slovene' ORDER BY l.percentage DESC")
	List<Object[]> allCountriesWhereLanguageSlovene();
	
	@Query("SELECT c.name, c.region, COUNT(ci) FROM Country c JOIN c.cities ci GROUP BY c.name ORDER BY COUNT(ci) DESC")
	List<Object[]> numberCitiesByCountry();
	
	List<Country> findAll();
	
	@Query("SELECT c.name, c.surface_area, c.population FROM Country c WHERE c.surface_area < 501 and c.population > 100000")
	List<Object[]> countriesSurfaceAreaBelow501PopGreater100000();
	
	@Query("SELECT c.name, c.government_form, c.surface_area, c.life_expectancy FROM Country c WHERE c.government_form = 'Constitutional Monarchy' AND c.surface_area > 200 AND c.life_expectancy > 75")
	List<Object[]> countriesConstitutionalMonarchy();
	
	@Query("SELECT c.region, COUNT(c) FROM Country c GROUP BY c.region ORDER BY COUNT(c) DESC")
	List<Object[]> summaryCountriesInRegion();

	
}
