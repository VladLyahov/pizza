package com.company.entity;

/**
 * Created by govno on 27.03.2016.
 */
public class Driver {
    private final int id;
    private final String name;
    private final int phone;
    private final String location;
    private final String workload;
    private final double till;

    public Driver(int id, String name, int phone, String location, String workload, double till) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.workload = workload;
        this.till = till;
    }
}
