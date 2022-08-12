package com.shopforhome.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopforhome.models.Cart;
import com.shopforhome.models.Customer;
import com.shopforhome.models.Product;
import com.shopforhome.repos.CartRepository;

@Service
public class CartService {

	@Autowired private CartRepository cartrepository;
	@Autowired private CustomerService customerservice;
	
	
	
	
	
	
	
	
	public void save(Cart wl) {
		cartrepository.save(wl);
	}
		public List<Cart> findByuserid(int id){
		return cartrepository.findByCustomer(customerservice.findById(id));
	}
	
	public void updateQty(int cartid,int qty) {
		Cart c=cartrepository.findById(cartid).get();
		c.setQty(qty);
		cartrepository.save(c);
	}
	
	
	
	
	public void deleteItem(int id) {
		cartrepository.deleteById(id);
	}
	
	public boolean checkexist(Customer customer,Product product) {
		return cartrepository.findByCustomerAndProduct(customer, product)!=null;
	}
	
	public void clearCart(Customer cust) {
	
		cartrepository.deleteAll(cartrepository.findByCustomer(cust));
	}
	
}
