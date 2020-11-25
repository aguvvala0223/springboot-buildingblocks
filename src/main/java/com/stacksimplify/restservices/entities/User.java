package com.stacksimplify.restservices.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "user")
//@JsonIgnoreProperties({"firstName","lastName"})
//@JsonFilter(value = "userFilter")
public class User {
	
	@Id
	@GeneratedValue
	@JsonView(Views.External.class)
	private Long id;
	
	@JsonView(Views.External.class)
	@NotEmpty(message= "UserName is a mandatory field.Please provide username")
	@Column(name = "USER_NAME",length = 50, nullable=false, unique=true)
	private String userName;
	
	@JsonView(Views.External.class)
	@Size(min=2, message="FirstName should have atleast 2 characters")
	@Column(name = "FIRST_NAME",length = 50, nullable=false)
	private String firstName;
	
	@JsonView(Views.External.class)
	@Column(name = "LAST_NAME",length = 50, nullable=false)
	private String lastName;
	
	@JsonView(Views.External.class)
	@Column(name = "EMAIL",length = 50, nullable=false)
	private String email;
	
	@JsonView(Views.Internal.class)
	@Column(name = "ROLE",length = 50, nullable=false)
	private String role;
	
	@JsonView(Views.Internal.class)
	//@JsonIgnore
	@Column(name = "SSN",length = 50, nullable=false, unique=true)
	private String ssn;
	
	@JsonView(Views.Internal.class)
	@OneToMany(mappedBy="user")
	private List<Order> orders;
	
	public User() {
		
	}
	
	public User(Long id, String userName, String firstName, String lastName, String email, String role, String ssn) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + ", orders=" + orders + "]";
	}


}
