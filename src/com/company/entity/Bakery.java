package com.company.entity;

/**
 * Created by govno on 27.03.2016.
 */
public class Bakery {
    private final int id;
    private final int phone;
    private final int stockAvailability;

    public Bakery(int id, int phone, int stockAvailability) {
        this.id = id;
        this.phone = phone;
        this.stockAvailability = stockAvailability;
    }
}
