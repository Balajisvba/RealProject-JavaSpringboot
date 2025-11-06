package com.RealProject.RealProject.Controller;

import com.RealProject.RealProject.Model.Customer;
import com.RealProject.RealProject.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    @PostMapping("/customer")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
        String data = customerServices.addCustomer(customer);
        return ResponseEntity.ok(data);
    }
    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> data = customerServices.getAllCustomer();
        return ResponseEntity.ok(data);
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@RequestParam int id){
        Customer data = customerServices.getCustomerById(id);
        return ResponseEntity.ok(data);
    }
    @PostMapping("/cust")
    public ResponseEntity<Customer> getCustomer(@RequestParam int id){
        Customer data= customerServices.getCustomer(id);
        return ResponseEntity.ok(data);
    }
    @PutMapping("/customer")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer){
        String data=customerServices.updateCustomer(customer);
        return ResponseEntity.ok(data);

    }
}
