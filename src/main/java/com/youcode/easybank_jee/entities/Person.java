package com.youcode.easybank_jee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    protected String _lastName;

    protected String _firstName;

    protected LocalDate _birthDate;

    protected String _phone;

    protected String _address;
}
