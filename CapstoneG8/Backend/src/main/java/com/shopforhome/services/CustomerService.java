package com.shopforhome.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopforhome.models.Customer;
import com.shopforhome.repos.CustomerRepository;

@Service
public class CustomerService {
	@Autowired private CustomerRepository customerrepository;

	
	public void registerCustomer(Customer customer) {
		customerrepository.save(customer);
	}

	
	public List<Customer> allCustomers() {
		return customerrepository.findAll();
	}

	
	public Customer findById(int id) {
		return customerrepository.findById(id).orElse(null);
	}

	
	public Customer validate(String userid, String pwd) {
		Customer c=customerrepository.findByUserid(userid);
		if(c!=null && c.getPwd().equals(pwd)) {
			return c;
		}
		return null;
	}
	
	
	public boolean verifyUserId(String userid) {
		return customerrepository.findByUserid(userid)!=null;
	}

	
	public void updateProfile(Customer customer) {
		if(customer.getPwd().equals("") || customer.getPwd()==null) {
			customer.setPwd(findById(customer.getId()).getPwd());
		}
		customerrepository.save(customer);	
	}


	public void deleteProduct(int id) {
		customerrepository.deleteById(id);
		
	}
}
