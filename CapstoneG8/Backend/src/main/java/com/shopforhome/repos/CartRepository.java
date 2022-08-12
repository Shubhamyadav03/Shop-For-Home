package com.shopforhome.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopforhome.models.Cart;
import com.shopforhome.models.Customer;
import com.shopforhome.models.Product;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	List<Cart> findByCustomer(Customer cust);
	Cart findByCustomerAndProduct(Customer customer,Product product);
	void deleteByCustomer(Customer cust);
}
