package com.bridgelabz.addressbookapp.service;

import java.util.List;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.model.Address;


public interface IAddressService {
	public Address  saveAddress(AddressDTO dto);
	
	public List<Address> getListOfAddresses();
	
	public Address getAddressbyId(Integer id);
	
	public Address updateAddressById(Integer id, AddressDTO dto);
	
	public Address deleteAddressById(Integer id);
}
