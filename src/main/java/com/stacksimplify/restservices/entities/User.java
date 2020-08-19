package com.stacksimplify.restservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // if no name provided, entity name is same as classname
@Table(name="user") // creates table with same name as name specified, else same as classname, we can mention schema too
public class User {

	@Id // used for primary key in JPA
	@GeneratedValue // for auto generating ids, can be diff ways, here we are using default (auto increment)
	private long id;
	
	@Column(name = "USER_NAME", length = 50, nullable = false, unique=true)
	private String username;
	
	@Column(name = "FIRST_NAME" , length = 50, nullable = false)
	private String firstname;
	
	@Column(name = "LAST_NAME" , length = 50, nullable = false)
	private String lastname;
	
	@Column(name = "EMAIL_ADDRESS" , length = 50, nullable = false)
	private String email;
	
	@Column(name = "ROLE" , length = 50, nullable = false)
	private String role;
	
	@Column(name="SSN", length = 50, nullable = false, unique = true)
	private String ssn;

	//No arg constructor - must have for JPA	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//Fields constructor - optional
	public User(long id, String username, String firstname, String lastname, String email, String role, String ssn) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}


	//getters setters  - mandatory
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getSsn() {
		return ssn;
	}


	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	
	//toString()

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}


}
