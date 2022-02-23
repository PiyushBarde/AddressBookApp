package com.bridgelabz.addressbookapp.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	public Address postAddress(@RequestBody Address address) {
		Address newAddress = new Address(address);
		repo.save(newAddress);
		return newAddress;
	}
	
	@GetMapping("/get")
	public List<Address> getAddress() {
		List<Address> address = repo.findAll();
		return address;
	}
	
	@GetMapping("/get/{id}")
	public Address getAddressById(@PathVariable Integer id) {
		Optional<Address> address = repo.findById(id);
		return address.get();
	}
	
	@PutMapping("/update/{id}")
	public Address updateAddress(@PathVariable Integer id) {
		Optional<Address> address = repo.findById(id);
		Address newAddress = new Address(id,address.get());
		return newAddress;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAddress(@PathVariable Integer id) {
		repo.deleteById(id);
		return "Address of id: " + id + " has been deleted";
	}
}

