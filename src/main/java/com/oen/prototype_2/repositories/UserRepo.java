package com.oen.prototype_2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oen.prototype_2.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{
	public List<User> findAll();
	
	public User save(User u);
	
	User findByEmail(String email);
	
	User findOne(Long id);
}
