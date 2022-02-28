package com.bridgelabz.addressbookapp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AddressDTO {
	@Pattern(regexp = "^[A-Z]{1}[a-z A-Z]{2,}",message = "invalid first name first word must be capital")
	private String firstName;
	@Pattern(regexp = "^[A-Z]{1}[a-z A-Z]{2,}",message = "invalid last name first word must be capital")
	private String lastName;
	@Email
	private String email;
	@NotNull
	private long phoneNumber;
	@NotEmpty(message = "city must be filled")
	private String city;
	@NotBlank(message = "state must be filled")
	private String state;
	@NotNull(message = "zip must be filled")
	private Integer zip;
}
