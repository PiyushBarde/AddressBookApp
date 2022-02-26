package com.bridgelabz.addressbookapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.exceptions.AddressbookAppException;
import com.bridgelabz.addressbookapp.model.Address;
import com.bridgelabz.addressbookapp.repository.AddressRepository;
import com.bridgelabz.addressbookapp.util.EmailSenderService;
import com.bridgelabz.addressbookapp.util.TokenUtil;


@Service
public class AddressService implements IAddressService{
	
	@Autowired
	AddressRepository repo;
	
	@Autowired
	TokenUtil tokenUtil;
	
	@Autowired
	private EmailSenderService sender;
	
	public List<Address> getListOfAddresses(String key) {
		if(key.compareTo(sender.getUniversalkey())!=0) {
			throw new AddressbookAppException("Invalid token"); 
		}
		List<Address> list = repo.findAll();
		if(list.isEmpty()) {
			throw new AddressbookAppException("Addressbook is empty");
		}
		else {
		return list;
		}	
	}
	
	//to add the address to the address book (validation applied from validation starter dependency)
	public String  saveAddress(AddressDTO dto) {
		Address address = new Address(dto);
		repo.save(address);
		String token = tokenUtil.createToken(address.getId());
	//	sender.sendEmail("piyushbarde1@gmail.com", "about the address added", "token : " + token);
		sender.sendEmail("piyushbarde1@gmail.com", "about the address added", "http://localhost:8080/addressbook/getAddress/" + token + " use this token to retrive address");
		return token;
	}
	
	//to get the specific through id passed as variable address from address book (using stream)	
	public Address getAddressbyId(String token) {
		Integer id = tokenUtil.decodeToken(token);
		List<Address> allAddresses = repo.findAll();
		Address address = allAddresses.stream()
				.filter(addressBookData->addressBookData.getId()==id)
				.findFirst()
				.orElseThrow(()-> new AddressbookAppException("Token is Invalid"));
		sender.sendEmail("piyushbarde1@gmail.com", "address from addressbook", "address ur request for: " + address.toString());
		return address;
	}

	//to update the address through id passed as variable address from address book (using .findById & .isPresent)
	public Address updateDateById(String token, AddressDTO dto) {
		Integer id = tokenUtil.decodeToken(token);
		Optional<Address> address = repo.findById(id);
		if(address.isPresent()) {
			Address newAddress = new Address(id,dto);
			repo.save(newAddress);
			sender.sendEmail("piyushbarde1@gmail.com", "address is updated", "Your token will remain same & new address is : " + newAddress.toString());
			return newAddress;
		}
		else {
			throw new AddressbookAppException("Employee not found");
		}
	}
	
	//to delete contact from address book (using .findById & .isEmpty)
	public Address deleteContact(String token) {
		Integer id = tokenUtil.decodeToken(token);
		Optional<Address> address = repo.findById(id);
		if(address.isEmpty()) {
			throw new AddressbookAppException("Invalid token..please input valid token");
		}
		repo.deleteById(id);
		sender.sendEmail("piyushbarde1@gmail.com", "address is deleted", "address with token : " + token +
							"\n & this address :" + address.toString() + " has been deleted");
		return address.get();
	}
}
