package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long UserId;
	
	@Column(nullable = false, unique = true, length = 45)
	private String userEmail;
	
	@Column(nullable = false, length = 20)
	private String userFirstName;
	
	@Column(nullable = false, length = 20)
	private String userLastName;
	
	@Column(nullable = false, length = 128)
	private String userPassword;
	
	@Column(nullable = false, length = 10)
	private String departnment;

	public Long getUserId() {
		return UserId;
	}

	public void setUserId(Long userId) {
		UserId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getDepartnment() {
		return departnment;
	}

	public void setDepartnment(String departnment) {
		this.departnment = departnment;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long userId, String userEmail, String userFirstName, String userLastName, String userPassword,
			String departnment) {
		super();
		UserId = userId;
		this.userEmail = userEmail;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPassword = userPassword;
		this.departnment = departnment;
	}
	
	

	
	

}
