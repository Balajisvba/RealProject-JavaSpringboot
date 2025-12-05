package com.RealProject.RealProject.Controller;


import com.RealProject.RealProject.Model.Bill;
import com.RealProject.RealProject.Services.BillService;
import com.RealProject.RealProject.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BillController {

    @Autowired
    private BillService billservice;

    @GetMapping("/bills")
    public List<Bill> getAllBills(){
        return billservice.getAllBills();
    }

    @GetMapping("/customers/{customerId}/bills")
    public List<Bill> getBillsByCustomer(@PathVariable Long customerId){
        return billservice.getBillsByCustomer(customerId);
    }
    @PostMapping("/bills")
    public Bill createBill(@RequestParam int billMonth,@RequestParam int customerId) {
        return billservice.saveBill(billMonth,customerId);
    }




}
