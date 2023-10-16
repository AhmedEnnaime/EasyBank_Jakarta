package com.youcode.easybank_jee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee extends Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricule;

    private LocalDate recruitmentDate;

    private String email;

    @OneToMany(mappedBy = "employee")
    private List<Client> clients;

    @ManyToOne
    @JoinColumn(name = "agency_code")
    private Agency agency;

    public Employee(String lastName, String firstName, LocalDate birthDate, String phone, String address,
                    Long matricule, LocalDate recruitmentDate, String email, List<Client> clients) {
        super(lastName, firstName, birthDate, phone, address);
        this.matricule = matricule;
        this.recruitmentDate = recruitmentDate;
        this.email = email;
        this.clients = clients;
    }

    public Employee(String lastName, String firstName, LocalDate birthDate, String phone, String address,
                    LocalDate recruitmentDate, String email, Agency agency) {
        super(lastName, firstName, birthDate, phone, address);
        this.recruitmentDate = recruitmentDate;
        this.email = email;
        this.agency = agency;
    }
}
