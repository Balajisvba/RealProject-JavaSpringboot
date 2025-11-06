package com.RealProject.RealProject.Services;


import com.RealProject.RealProject.Exception.CustomerNotFoundException;
import com.RealProject.RealProject.Exception.DeleveryNotFoundException;
import com.RealProject.RealProject.Model.Delivery;
import com.RealProject.RealProject.Repository.DeliveryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServices {

    @Autowired
    DeliveryRepo deliveryRepo;

    public String addDelivery(Delivery delivery){
        deliveryRepo.save(delivery);
        return "Delivery added Successfully";
    }
    public List<Delivery> getAllDeliveries(){
        List<Delivery> allDeliveries = deliveryRepo.findAll();
        return allDeliveries;
    }
    public String updateDelivery(int id){
        Delivery del=deliveryRepo.findById(id).orElseThrow(()->new DeleveryNotFoundException("Delivery Not Found at this id"+id));
        return "Update it not happend because of no data";
    }
    public String deleteDelivery(int id){
        deliveryRepo.deleteById(id);
        return "Delevery Deleted Successfully";
    }
}
