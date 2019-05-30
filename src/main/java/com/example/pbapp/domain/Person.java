package com.example.pbapp.domain;

import java.util.Date;

/**
 * This Person model will hold the common detail from User and Contact
 * @author arju.yadav
 *
 */
public class Person {
	/**
	 * id of Person
	 * primary key
	 */
	private Integer id;
	/**
	 * name of Person
	 */
	private String name;
	/**
	 * phone number of Person
	 */
	private String phone;
	/**
	 * address of Person
	 */
	private String address;
	/**
	 * email of Person
	 */
	private String email;
	/**
	 * created date of Person
	 */
	private Date created_at;
	/**
	 * updated date of Person
	 */
	private Date updated_at;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
}
