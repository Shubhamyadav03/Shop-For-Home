package com.shopforhome.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopforhome.models.Address;
import com.shopforhome.repos.AddressRepository;

@Service
public class AddressService {

	@Autowired AddressRepository dao;
	
	public Address saveAddress(Address address) {
		return dao.save(address);
	}

	public Address findAddress(int id) {
		return dao.findById(id).get();
	}
}
