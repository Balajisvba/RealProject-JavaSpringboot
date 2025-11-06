package com.RealProject.RealProject.Services;


import com.RealProject.RealProject.Model.Delivery;
import com.RealProject.RealProject.Repository.DeliveryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.aspectj.runtime.internal.Conversions.intValue;

import java.util.List;


@Service
public class DeliveryServices {

    @Autowired
    DeliveryRepo deliveryRepo;

    public String addDelivery(Delivery delivery){
        deliveryRepo.save(delivery);
        return "Delivery added Successfully";
    }
    public List<Delivery> getAllDeliveries() {
        List<Delivery> allDeliveries = deliveryRepo.findAll();
        return allDeliveries;
    }

    public String updateDelivery(Delivery del){
        int id=intValue(del.getId());
        Delivery delivery = deliveryRepo.findById(id).orElseThrow();
        delivery.setCustomer(del.getCustomer());
        delivery.setDelivaryDate(del.getDelivaryDate());
        delivery.setNumOfCans(del.getNumOfCans());
        deliveryRepo.save(delivery);
        return "Updated Successfully for Delivery";
    }

}
