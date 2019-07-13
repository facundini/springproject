package com.facundini.springboot.thymeleafdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Employee {
	
	@NotBlank(message="")
	//@Pattern(regexp = "")
	private String email;
	
	@NotBlank(message="")
	@Size(min=2, max=30, message ="El nombre debe tener entre 2 y 30 caracteres.")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message="")
	@Size(min=2, max=30, message ="El apellido debe tener entre 2 y 30 caracteres.")
	@Column(name="last_name")
	private String lastName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	public Employee() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
