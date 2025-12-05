package com.RealProject.RealProject.Repository;

import com.RealProject.RealProject.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepo extends JpaRepository<Bill ,Long> {
    List<Bill> findByCustomerId(Long customerId);
}
