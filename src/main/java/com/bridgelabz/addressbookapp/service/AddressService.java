package com.bridgelabz.addressbookapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.model.Address;
import com.bridgelabz.addressbookapp.repository.AddressRepository;

@Service
public class AddressService implements IAddressService{
	@Autowired
	AddressRepository repo;
	
	public List<Address> getListOfAddresses() {
		List<Address> list = repo.findAll();
		return list;
		}
	
	public Address  saveAddress(AddressDTO dto) {
		Address address = new Address(dto);
		repo.save(address);
		return address;
	}
		
	public Address getAddressbyId(Integer id) {
		Optional<Address> address = repo.findById(id);
		return address.get();
	}

	public Address updateDateById(Integer id, AddressDTO dto) {
		Address address = new Address(id,dto);
		repo.save(address);
		return address;
	}
	
	public void deleteContact(Integer id) {
		repo.deleteById(id);
	}
}
