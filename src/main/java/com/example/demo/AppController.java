package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class AppController {
	
	String email;
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private MarksRepository marksRepo;
	
	@Autowired
	private CustomUserDetails customUserDetails;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		System.out.println(model);
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = user.getUserPassword();
		email = user.getUserEmail();
		String encodedPassword = encoder.encode(rawPassword);
		user.setUserPassword(encodedPassword);
		repo.save(user);
		System.out.println(encodedPassword);
		return "register_success";
	}
	
	@GetMapping("/entermarks")
	public String enterMarks(Model model) {
		model.addAttribute("marks", new UserMarks());
		System.out.println(model);
		return "enter_marks";
	}
	
	@PostMapping("/process_marks")
	public String processMarks(UserMarks marks) {
		if(email==null) {
			email = customUserDetails.getUsername();
		}
		System.out.println(email);
		long id = repo.findUserIdByEmail(email);
		marks.setUserId(id);
		System.out.println(id);
		marksRepo.save(marks);
		return "enter_marks_success";
	}
	
	@GetMapping("/list_users")
	public String viewUsersList(Model model) {
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		List<UserMarks> listMarks = marksRepo.findAll();
		model.addAttribute("listMarks",listMarks);
		return "users";
	}
	
	
}
