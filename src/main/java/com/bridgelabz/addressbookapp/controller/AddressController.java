package com.bridgelabz.addressbookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	@GetMapping("/get")
	public ResponseEntity<String>getAllData(){
		List<Address> listOfContacts = service.getListOfAddresses();
		ResponseDTO response = new ResponseDTO("Addresbook :", listOfContacts);
		return new ResponseEntity(response,HttpStatus.OK);
	}
	
	//to add the address to the address book (validation applied from validation starter dependency)
	@PostMapping("/post")
	public ResponseEntity<ResponseDTO> postData(@RequestBody AddressDTO dto) {
		Address newContact = service.saveAddress(dto);
		ResponseDTO response = new ResponseDTO("New Contact Added in Addressbook : ", newContact);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	//to get the specific through id passed as variable address from address book (using stream)
	@GetMapping("/get/{id}")
	public  ResponseEntity<Address> retriveData(@PathVariable Integer id){
		ResponseDTO response = new ResponseDTO("Addressbook of given id: ",service.getAddressbyId(id));
		return new ResponseEntity(response,HttpStatus.OK);
	}
	
	//to update the address through id passed as variable address from address book (using .findById & .isPresent)
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateById(@PathVariable Integer id,@RequestBody AddressDTO dto){
		Address newContact = service.updateDateById(id,dto);
		ResponseDTO response = new ResponseDTO("Addressbook updated : ", newContact);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	//to delete contact from address book (using .findById & .isEmpty)
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteDataById(@PathVariable Integer id){
		service.deleteContact(id);
		return new ResponseEntity<String>("Contact deleted succesfully",HttpStatus.OK);
	}
}

