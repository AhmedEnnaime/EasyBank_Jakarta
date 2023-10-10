package com.youcode.easybank_jee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends Person{
    private int _code;

    private Employee _employee;

    public Client(String lastName, String firstName, LocalDate birthDate, String phone, String address, int code, Employee employee) {
        super(lastName, firstName, birthDate, phone, address);
        this._code = code;
        this._employee = employee;
    }

    public Client(String lastName, String firstName, LocalDate birthDate, String phone, String address) {
        super(lastName, firstName, birthDate, phone, address);
    }

    public Client(String lastName, String firstName, LocalDate birthDate, String phone, String address, Employee employee) {
        super(lastName, firstName, birthDate, phone, address);
        this._employee = employee;
    }
}
