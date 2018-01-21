package com.amol.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.amol.spring.data.jpa.entity.Address;

public interface AddressRepository extends CrudRepository<Address, String>{
	
	 List<Address> findByPostCode(String postCode);

}
