package com.youcode.easybank_jee.entities;

import com.youcode.easybank_jee.enums.STATE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    private Integer number;

    private LocalDate credit_date;

    private Double amount;

    private STATE state;

    private String remarks;

    private Integer duration;

    private Simulation simulation;

    public Request(LocalDate credit_date, Double amount, STATE state, String remarks, Integer duration, Simulation simulation) {
        this.credit_date = credit_date;
        this.amount = amount;
        this.state = state;
        this.remarks = remarks;
        this.duration = duration;
        this.simulation = simulation;
    }
}
