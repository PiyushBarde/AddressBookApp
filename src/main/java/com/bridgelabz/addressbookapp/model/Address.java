package com.bridgelabz.addressbookapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.bridgelabz.addressbookapp.dto.AddressDTO;

import lombok.Data;

@Entity
@Data
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
}
