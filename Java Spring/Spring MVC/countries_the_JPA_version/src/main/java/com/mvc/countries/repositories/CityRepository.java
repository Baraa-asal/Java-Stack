package com.mvc.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mvc.countries.models.City;

public interface CityRepository extends CrudRepository<City, Long> {
	List<City> findAll();
	
	@Query("SELECT ci.name, ci.population FROM City ci JOIN ci.country c WHERE c.name  = 'Mexico' AND ci.population > 500000 ORDER BY ci.population DESC")
	List<Object[]> citiesInMexicoMoreThan500KPop();
	
	@Query("SELECT ci.name, ci.district, ci.population FROM City ci")
	List<Object[]> argentinaCitiesInBuenosAires();
}