package com.RealProject.RealProject.Model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate deliveryDate;
    private int numOfCans;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getNumOfCans() {
        return numOfCans;
    }

    public void setNumOfCans(int numOfCans) {
        this.numOfCans = numOfCans;
    }

    public LocalDate getDelivaryDate() {
        return deliveryDate;
    }

    public void setDelivaryDate(LocalDate delivaryDate) {
        this.deliveryDate = delivaryDate;
    }
}
