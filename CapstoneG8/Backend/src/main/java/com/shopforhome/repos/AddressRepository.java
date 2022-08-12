package com.shopforhome.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopforhome.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
