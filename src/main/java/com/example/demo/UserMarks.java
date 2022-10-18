package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marks")
public class UserMarks {

	@Id
	@Column(nullable = false)
	private long userId;
	
	@Column(nullable = false, length = 2)
	private int java;
	
	@Column(nullable = false, length = 2)
	private int python;
	
	@Column(nullable = false, length = 2)
	private int cLanguage;
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getPython() {
		return python;
	}
	public void setPython(int python) {
		this.python = python;
	}
	public int getcLanguage() {
		return cLanguage;
	}
	public void setcLanguage(int cLanguage) {
		this.cLanguage = cLanguage;
	}
	
	
}
