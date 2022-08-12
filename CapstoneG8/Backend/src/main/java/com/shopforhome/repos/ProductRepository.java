package com.shopforhome.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopforhome.models.Category;
import com.shopforhome.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByCategory(Category cat);
	List<Product> findByPnameOrDescrContaining(String t1,String t2);
}
