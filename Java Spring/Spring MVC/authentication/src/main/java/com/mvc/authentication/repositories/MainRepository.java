package com.mvc.authentication.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.authentication.models.User;

@Repository
public interface MainRepository extends CrudRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    List<User> findAll();
	Optional<User> findById(Long id);
    Optional<User> findByUserName(String userName);
}