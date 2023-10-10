package com.youcode.easybank_jee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Person{
    private int _matricule;

    private LocalDate _recruitmentDate;

    private String _email;

    public Employee(String lastName, String firstName, LocalDate birthDate, String phone, String address,
                    int matricule, LocalDate recruitmentDate, String email) {
        super(lastName, firstName, birthDate, phone, address);
        this._matricule = matricule;
        this._recruitmentDate = recruitmentDate;
        this._email = email;
    }

    public Employee(String lastName, String firstName, LocalDate birthDate, String phone, String address,
                    LocalDate recruitmentDate, String email) {
        super(lastName, firstName, birthDate, phone, address);
        this._recruitmentDate = recruitmentDate;
        this._email = email;
    }
}
