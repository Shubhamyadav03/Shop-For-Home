package com.shopforhome.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopforhome.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

}
