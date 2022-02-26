package com.bridgelabz.addressbookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.Address;
import com.bridgelabz.addressbookapp.service.AddressService;

@RestController
@RequestMapping("/addressbook")
public class AddressController {
	
	@Autowired
	AddressService service;
	
	@GetMapping("")
	public String welcomeUser() {
		return "Welcome to the addressbook app";
	}
	
	//to get all the addresses present in address book (using .findAll())
	@GetMapping("/get/{key}")
	public ResponseEntity<String>getAllData(@PathVariable String key){
		List<Address> listOfContacts = service.getListOfAddresses(key);
		ResponseDTO response = new ResponseDTO("Addresbook :", listOfContacts);
		return new ResponseEntity(response,HttpStatus.OK);
	}
	
	//to add the address to the address book (validation applied from validation starter dependency)
	@PostMapping("/post")
	public ResponseEntity<ResponseDTO> postData(@RequestBody AddressDTO dto) {
		String address = service.saveAddress(dto);
		ResponseDTO response = new ResponseDTO("New address Added in Addressbook : ", address);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	//to get the specific through id passed as variable address from address book (using stream)
	@GetMapping("/getAddress/{token}")
	public  ResponseEntity<Address> retriveData(@PathVariable String token){
		ResponseDTO response = new ResponseDTO("Addressbook of given id: ",service.getAddressbyId(token));
		return new ResponseEntity(response,HttpStatus.OK);
	}
	
	//to update the address through id passed as variable address from address book (using .findById & .isPresent)
	@PutMapping("/update/{token}")
	public ResponseEntity<ResponseDTO> updateById(@PathVariable String token,@RequestBody AddressDTO dto){
		Address newContact = service.updateDateById(token,dto);
		ResponseDTO response = new ResponseDTO("Addressbook updated : ", newContact);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	//to delete contact from address book (using .findById & .isEmpty)
	@DeleteMapping("/delete/{token}")
	public ResponseEntity<ResponseDTO> deleteDataById(@PathVariable String token){
		ResponseDTO response = new ResponseDTO("Contact deleted succesfully",service.deleteContact(token));
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
}

