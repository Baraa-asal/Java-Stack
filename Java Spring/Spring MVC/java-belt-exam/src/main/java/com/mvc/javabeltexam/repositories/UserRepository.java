package com.mvc.javabeltexam.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.javabeltexam.models.Team;
import com.mvc.javabeltexam.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    List<User> findAll();
	Optional<User> findById(Long id);
    Optional<User> findByUserName(String userName);
	List<User> findByTeamsNotContains(Team team);
}