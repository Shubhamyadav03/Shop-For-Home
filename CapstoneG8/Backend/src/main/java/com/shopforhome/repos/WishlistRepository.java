package com.shopforhome.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopforhome.models.Customer;
import com.shopforhome.models.Product;
import com.shopforhome.models.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
	
	List<Wishlist> findByCustomer(Customer customer);
	Wishlist findByCustomerAndProduct(Customer cust,Product pro);

}
