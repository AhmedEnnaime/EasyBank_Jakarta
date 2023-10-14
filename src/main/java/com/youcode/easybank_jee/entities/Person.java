package com.youcode.easybank_jee.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person {
    protected String lastName;
    protected String firstName;
    protected LocalDate birthDate;
    protected String phone;
    protected String address;
}
