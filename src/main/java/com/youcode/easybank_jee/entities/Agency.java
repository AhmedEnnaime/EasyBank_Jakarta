package com.youcode.easybank_jee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agencies")
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String name;

    private String address;

    private String phone;

    @OneToMany(mappedBy = "agency")
    private List<Employee> employees;

    @OneToMany(mappedBy = "agency")
    private List<Request> requests;

    public Agency(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}
