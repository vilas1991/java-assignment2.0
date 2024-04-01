package com.webapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webapp.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u.id FROM User u WHERE u.username = :username")
	 Long findUserIdByUsername(String username);
	
	
}
