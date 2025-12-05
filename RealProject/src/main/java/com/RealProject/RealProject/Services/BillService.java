package com.RealProject.RealProject.Services;

import com.RealProject.RealProject.Exception.CustomerNotFoundException;
import com.RealProject.RealProject.Model.Bill;
import com.RealProject.RealProject.Model.Customer;
import com.RealProject.RealProject.Repository.BillRepo;
import com.RealProject.RealProject.Repository.CustomerRepo;
import com.RealProject.RealProject.Repository.DeliveryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;

@Service
public class BillService {
    @Autowired
    private BillRepo billRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private DeliveryRepo delRepo;

    public List<Bill> getAllBills(){
        return billRepo.findAll();
    }
    public Bill saveBill(int billMonth,int customerId) {
        Bill bill =new Bill();
        Customer customer=customerRepo.findById(customerId).orElseThrow(()-> new CustomerNotFoundException("Cutomer Not Found"));
        double totAmount= delRepo.totCans(billMonth,customerId)*customer.getPricePerCan();
        bill.setBillMonth(billMonth);
        bill.setCustomer(customer);
        bill.setGeneratedDate( LocalDate.now());
        bill.setTotalAmount(totAmount);

        return billRepo.save(bill);
    }
    public List<Bill> getBillsByCustomer(Long customerId) {
        return billRepo.findByCustomerId(customerId);
    }

}
