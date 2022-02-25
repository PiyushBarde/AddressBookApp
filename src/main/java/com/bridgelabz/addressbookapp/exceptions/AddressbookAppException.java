package com.bridgelabz.addressbookapp.exceptions;

public class AddressbookAppException extends RuntimeException{      //<-custom exception class which shows the message we gave when we throw any new
	public AddressbookAppException(String message) {				//	exception.
		super(message);
	}
}
