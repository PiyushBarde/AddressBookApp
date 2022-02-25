package com.bridgelabz.addressbookapp.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.exceptions.AddressbookAppException;
import com.bridgelabz.addressbookapp.model.Address;
import com.bridgelabz.addressbookapp.repository.AddressRepository;

@Service
public class AddressService implements IAddressService{
	
	@Autowired
	AddressRepository repo;
	
	//to get all the addresses present in address book (using .findAll())
	public  List<Address> getListOfAddresses() {
		List<Address> list = repo.findAll();
		if(list.isEmpty()) {
			throw new AddressbookAppException("Addressbook is empty");
		}
		else {
		return list;
		}
	}
	
	//to add the address to the address book (validation applied from validation starter dependency)
	public Address  saveAddress(AddressDTO dto) {
		Address address = new Address(dto);
		repo.save(address);
		return address;
	}
	
	//to get the specific through id passed as variable address from address book (using stream)	
	public Address getAddressbyId(Integer id) {
		List<Address> allAddresses = repo.findAll();
		Address address = allAddresses.stream()
				.filter(addressBookData->addressBookData.getId()==id)
				.findFirst()
				.orElseThrow(()-> new AddressbookAppException("Employee Not found"));
		return address;
	}

	//to update the address through id passed as variable address from address book (using .findById & .isPresent)
	public Address updateAddressById(Integer id, AddressDTO dto) {
		Optional<Address> address = repo.findById(id);
		if(address.isPresent()) {
			Address newAddress = new Address(id,dto);
			repo.save(newAddress);
			return newAddress;
		}
		else {
			throw new AddressbookAppException("Employee not found");
		}
	}
	
	//to delete contact from address book (using .findById & .isEmpty)
	public Address deleteAddressById(Integer id) {
		Optional<Address> addressToDelete = repo.findById(id);
		if(addressToDelete.isEmpty()) {
			throw new AddressbookAppException("Invalid id..please input valid id");
		}
		Address address = addressToDelete.get();
		repo.deleteById(id);
		return address;
	}
}
