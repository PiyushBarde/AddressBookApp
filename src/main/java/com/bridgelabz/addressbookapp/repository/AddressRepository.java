package com.bridgelabz.addressbookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.addressbookapp.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
