package com.bridgelabz.addressbookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.addressbookapp.model.Address;
//JPA lest us do curd operations and custom methods
public interface AddressRepository extends JpaRepository<Address, Integer>{  //<- here value is Address(model) and Integer(id) is key

}
