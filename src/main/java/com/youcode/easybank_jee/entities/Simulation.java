package com.youcode.easybank_jee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Simulation {

    private Integer id;

    private Double monthly_payment;

    private Double borrowed_capital;

    private Integer monthly_payment_num;

    private Double proportional_annual_rate = 0.12;

    private Client client;

    private Employee employee;

    public Simulation(Double borrowed_capital, Integer monthly_payment_num, Client client) {
        this.borrowed_capital = borrowed_capital;
        this.monthly_payment_num = monthly_payment_num;
        this.client = client;
    }

}
