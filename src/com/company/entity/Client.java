package com.company.entity;

/**
 * Created by govno on 27.03.2016.
 */
public class Client {

    private final int phone;
    private final String addres;
    private final int idPizza;
    private final double paymentAmount;
    private final long time;

    public Client(int phone, String addres, int idPizza, double paymentAmount, long time) {
        this.phone = phone;
        this.addres = addres;
        this.idPizza = idPizza;
        this.paymentAmount = paymentAmount;
        this.time = time;
    }


}
