package com.bridgelabz.addressbookapp.dto;

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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getContact() {
		return contact;
	}
	public void setContact(Object contact) {
		this.contact = contact;
	}
	
}
