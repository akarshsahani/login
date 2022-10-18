package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	 
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private MarksRepository marksRepo;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUserEmail("123@gmail.com");
		user.setUserPassword("123@2001");
		user.setUserFirstName("123");
		user.setUserLastName("321");
		user.setDepartnment("CSE");
		
		User savedUser = repo.save(user);
		
		User existUser = entityManager.find(User.class, savedUser.getUserId());
		assertThat(existUser.getUserEmail()).isEqualTo(user.getUserEmail());
	}
	
	@Test
	public void testCreateMarks() {
		UserMarks marks = new UserMarks();
		marks.setUserId(repo.findUserIdByEmail("123@gmail.com"));
//		marks.setUserId(1);
		marks.setJava(5);
		marks.setPython(9);
		marks.setcLanguage(6);
		
		UserMarks savedMarks = marksRepo.save(marks);
		
		UserMarks exitMarks = entityManager.find(UserMarks.class, savedMarks.getUserId());
		assertThat(exitMarks.getUserId()).isEqualTo(marks.getUserId());
	}
	
	@Test
	public void testFindUserByEmail() {
		String email ="akash@gmail.com";
		
		User user = repo.findByEmail(email);
		
		assertThat(user).isNotNull();
	}

}
