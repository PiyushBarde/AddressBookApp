package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

@Data
public class ResponseDTO {
	public ResponseDTO() {
		super();
	}
	private String message;
	private Object contact;
	public ResponseDTO(String message,Object contact) {
		super();
		this.contact = contact;
		this.message = message;
	}	
}
