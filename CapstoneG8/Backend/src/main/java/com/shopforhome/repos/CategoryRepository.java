package com.shopforhome.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopforhome.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
