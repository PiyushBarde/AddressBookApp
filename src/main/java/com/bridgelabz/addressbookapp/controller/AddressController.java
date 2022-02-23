package com.bridgelabz.addressbookapp.controller;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.Response;
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
import com.bridgelabz.addressbookapp.repository.AddressRepository;

@RestController
@RequestMapping("/addressbook")
public class AddressController {
	
	@Autowired
	AddressRepository repo;
	
	@GetMapping("")
	public String getMessage() {
		return "Welcome to Addressbook App";
	}
	
	@PostMapping("/post")
	public ResponseEntity<ResponseDTO> postAddress(@RequestBody AddressDTO address) {
		Address newAddress = new Address(address);
		repo.save(newAddress);
		ResponseDTO response = new ResponseDTO("Address Added : ", newAddress);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getAddress() {
		List<Address> address = repo.findAll();
		ResponseDTO dto = new ResponseDTO("Address Book:",address);
		return new ResponseEntity<ResponseDTO>(dto,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getAddressById(@PathVariable Integer id) {
		Optional<Address> address = repo.findById(id);
		ResponseDTO dto = new ResponseDTO("Address ; ",address);
		return new ResponseEntity<ResponseDTO>(dto,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddress(@PathVariable Integer id,@RequestBody AddressDTO dto) {
		Address address = new Address(id,dto);
		ResponseDTO response = new ResponseDTO("Address Updated : ", address);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAddress(@PathVariable Integer id) {
		repo.deleteById(id);
		return "Address of id: " + id + " has been deleted";
	}
}

