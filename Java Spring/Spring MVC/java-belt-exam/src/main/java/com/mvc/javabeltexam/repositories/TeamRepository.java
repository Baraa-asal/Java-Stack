package com.mvc.javabeltexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.javabeltexam.models.Team;
import com.mvc.javabeltexam.models.User;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
	//	---- Retrieves all teams -------------------------------
	List<Team> findAll();
}