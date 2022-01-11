package com.company.model;

import javax.persistence.*;

@Entity(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    private int initialValue;
    @Column
    private int endValue;
    @Column
    private int price;
    @Column
    private int meter_id;

    public Invoice(int id, int initialValue, int endValue, int price, int meter_id) {
        this.id = id;
        this.initialValue = initialValue;
        this.endValue = endValue;
        this.price = price;
        this.meter_id = meter_id;
    }

    public Invoice() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(int initialValue) {
        this.initialValue = initialValue;
    }

    public int getEndValue() {
        return endValue;
    }

    public void setEndValue(int endValue) {
        this.endValue = endValue;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMeter_id() {
        return meter_id;
    }

    public void setMeter_id(int meter_id) {
        this.meter_id = meter_id;
    }
}
