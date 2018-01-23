package com.amol.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amol.spring.data.jpa.entity.Address;

public interface AddressRepository extends JpaRepository<Address, String>{
	
	 List<Address> findByPostCode(String postCode);

}
