package com.example.demo.model;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
	@Column
	private long mobile;
	@Column
	private String moviename;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date date;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, long mobile, String moviename, Date date) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.moviename = moviename;
		this.date = date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
