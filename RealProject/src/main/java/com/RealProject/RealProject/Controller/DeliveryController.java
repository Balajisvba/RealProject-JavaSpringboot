package com.RealProject.RealProject.Controller;
import com.RealProject.RealProject.Model.Delivery;
import com.RealProject.RealProject.Services.DeliveryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DeliveryController {

    @Autowired
    DeliveryServices deliveryServices;

    @PostMapping("/delivery")
    public ResponseEntity<String> addDelevery(@RequestBody Delivery delivery){
         String data=deliveryServices.addDelivery(delivery);
        return ResponseEntity.ok(data);
    }
    @GetMapping("/delevery")
    public ResponseEntity<List<Delivery>> getAllDeliveries(){
        List<Delivery> data= deliveryServices.getAllDeliveries();
        return ResponseEntity.ok(data);
    }
}
