package com.shopforhome.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopforhome.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
