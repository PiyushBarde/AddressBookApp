package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

@Data
public class AddressDTO {
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNumber;
	private String city;
	private String state;
	private Integer zip;
	
	public AddressDTO() {
		super();
	}
}
