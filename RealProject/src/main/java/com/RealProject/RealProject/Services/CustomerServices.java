package com.RealProject.RealProject.Services;


import com.RealProject.RealProject.Exception.CustomerNotFoundException;
import com.RealProject.RealProject.Model.Customer;
import com.RealProject.RealProject.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServices {

    @Autowired
    private CustomerRepo customerRepo;


    public String addCustomer(Customer customer){
        customerRepo.save(customer);
        return "Customer added Successfully";
    }

    public List<Customer> getAllCustomer(){
        List<Customer> allCustomers = customerRepo.findAll();
        return allCustomers;

    }
    public Customer getCustomerById(int id){
         Customer customerByID=customerRepo.findById(id).orElseThrow(() ->new CustomerNotFoundException("Customer Not Found with Id "+id));
         return customerByID;
    }
    public Customer getCustomer(int id){
        return customerRepo.findById(id).orElseThrow();}
}
