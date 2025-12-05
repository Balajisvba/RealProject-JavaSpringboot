package com.RealProject.RealProject.Repository;

import com.RealProject.RealProject.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment, Long>{

    List<Payment> findByCustomerId(Long customerId);
    List<Payment> findByBillId(Long billId);
}
