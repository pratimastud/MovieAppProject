package com.example.demo.model;
import jakarta.persistence.*;
@Entity
@Table(name="logintb")
public class Login {
	@Id
	private String userId;
	@Column
	private String password;
	
	public Login() {
		super();
		
	}

	public Login(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
