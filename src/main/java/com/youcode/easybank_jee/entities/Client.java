package com.youcode.easybank_jee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client extends Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;

    @ManyToOne
    @JoinColumn(name = "employeeMatricule")
    private Employee employee;

    public Client(String lastName, String firstName, LocalDate birthDate, String phone, String address, int code, Employee employee) {
        super(lastName, firstName, birthDate, phone, address);
        this.code = code;
        this.employee = employee;
    }

    public Client(String lastName, String firstName, LocalDate birthDate, String phone, String address) {
        super(lastName, firstName, birthDate, phone, address);
    }

    public Client(String lastName, String firstName, LocalDate birthDate, String phone, String address, Employee employee) {
        super(lastName, firstName, birthDate, phone, address);
        this.employee = employee;
    }
}
