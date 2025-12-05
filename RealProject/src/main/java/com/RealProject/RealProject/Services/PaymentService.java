package com.RealProject.RealProject.Services;

import com.RealProject.RealProject.Model.Payment;
import com.RealProject.RealProject.Repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    public List<Payment> gelAllPayment(){
        return paymentRepo.findAll();
    }
    public Payment savePayment(Payment payment){
        return paymentRepo.save(payment);
    }
    public List<Payment> getPaymentsByCustomerId(Long customerId){
        return paymentRepo.findByCustomerId(customerId);
    }

    public List<Payment> getPaymentByBillId(Long billId){
        return paymentRepo.findByBillId(billId);
    }
}
