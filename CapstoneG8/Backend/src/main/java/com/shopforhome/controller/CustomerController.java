package com.shopforhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopforhome.dtos.LoginDTO;
import com.shopforhome.dtos.Response;
import com.shopforhome.models.Customer;
import com.shopforhome.services.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Customer customer) {		
		System.out.println(customer);
		customerService.registerCustomer(customer);
		return Response.success(customer);
	}
	
	@GetMapping
	public List<Customer> findAllCustomers() {
		return customerService.allCustomers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findCustomerById(@PathVariable("id") int id) {
		Customer result = customerService.findById(id);
		return Response.success(result);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Customer user=customerService.validate(dto.getUserid(),dto.getPwd());
		if(user!=null)
			return Response.success(user);
		else
			return Response.status(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("{id}")
	public ResponseEntity<?> updateProfile(@RequestBody Customer customer,@PathVariable("id") int id) {
		customerService.updateProfile(customer);
		return Response.status(HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {
		customerService.deleteProduct(id);
		return Response.status(HttpStatus.OK);
	}

}
