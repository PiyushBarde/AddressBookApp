package com.bridgelabz.addressbookapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.bridgelabz.addressbookapp.dto.AddressDTO;

@Entity
public class Address {
	@Id
	@GeneratedValue
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNumber;
	private String city;
	private String state;
	private Integer zip;
	
	//---------------constructors---------------------//
	
	public Address(AddressDTO address) {
		super();
		this.firstName = address.getFirstName();
		this.lastName = address.getLastName();
		this.email = address.getEmail();
		this.phoneNumber = address.getPhoneNumber();
		this.city = address.getCity();
		this.state = address.getState();
		this.zip = address.getZip();
	}
	
	public Address() {
		super();
	}
	
	public Address(Integer id, AddressDTO address) {
		this.id=id;
		this.firstName = address.getFirstName();
		this.lastName = address.getLastName();
		this.email = address.getEmail();
		this.phoneNumber = address.getPhoneNumber();
		this.city = address.getCity();
		this.state = address.getState();
		this.zip = address.getZip();
	}
	
	//--------------Getters & Setters------------------//
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
}
