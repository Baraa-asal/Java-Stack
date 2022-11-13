package com.mvc.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dojosandninjas.models.Dojo;
import com.mvc.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	DojoRepository dojoRepo;
	
	//	---- Create a Dojo --------------------------
	
	public Dojo create(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}
	
	//	//// RETRIEVE ///////////////////////////////
	
	//	---- Retrieve All ---------------------------
	
	public List<Dojo> retrieveAll() {
		return this.dojoRepo.findAll();
	}
	
	//	---- Retrieve Dojo by ID --------------------
	
	public Dojo retrieveDojo(Long id) {
		Optional<Dojo> optDojo = this.dojoRepo.findById(id);
		if ( optDojo.isPresent() ) {
			return optDojo.get();			
		} else {
			return null;
		}
	}
	
	//	//// UPDATE ////////////
	
	public Dojo update(Dojo dojo) {
		Optional<Dojo> optDojo = this.dojoRepo.findById(dojo.getId());
		if ( optDojo.isPresent() ) {
			return this.dojoRepo.save(dojo);
		} else {
			return null;
		}
	}
	
	///// DELETE /////////////
	
	public void delete(Long id) {
		this.dojoRepo.deleteById(id);
	}
	
}