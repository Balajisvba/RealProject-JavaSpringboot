package com.RealProject.RealProject.Controller;

import com.RealProject.RealProject.Model.Payment;
import com.RealProject.RealProject.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @GetMapping("/payments")
    public List<Payment> getAllPayments() {
        return paymentService.gelAllPayment();
    }
    @GetMapping("/customers/{customerId}/payments")
    public List<Payment> getPaymentsByCustomer(@PathVariable Long customerId) {
        return paymentService.getPaymentByBillId(customerId);
    }

    @GetMapping("/bills/{billId}/payments")
    public List<Payment> getPaymentsByBill(@PathVariable Long billId) {
        return paymentService.getPaymentByBillId(billId);
    }
    @PostMapping("/payments")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

}
