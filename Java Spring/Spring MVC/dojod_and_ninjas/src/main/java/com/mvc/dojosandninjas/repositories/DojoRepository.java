package com.mvc.dojosandninjas.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.mvc.dojosandninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {

	List<Dojo> findAll();
	
}
