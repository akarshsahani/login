package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
	
	@Query("SELECT u FROM User u WHERE u.userEmail=?1")
	User findByEmail(String email);

	
	@Query(value = "select user_id from users where user_email = ?1", nativeQuery = true)
	long findUserIdByEmail(String email);
}
