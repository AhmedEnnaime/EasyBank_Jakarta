package com.youcode.easybank_jee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Person{
    private int matricule;

    private LocalDate recruitmentDate;

    private String email;

    public Employee(String lastName, String firstName, LocalDate birthDate, String phone, String address,
                    int matricule, LocalDate recruitmentDate, String email) {
        super(lastName, firstName, birthDate, phone, address);
        this.matricule = matricule;
        this.recruitmentDate = recruitmentDate;
        this.email = email;
    }

    public Employee(String lastName, String firstName, LocalDate birthDate, String phone, String address,
                    LocalDate recruitmentDate, String email) {
        super(lastName, firstName, birthDate, phone, address);
        this.recruitmentDate = recruitmentDate;
        this.email = email;
    }
}
