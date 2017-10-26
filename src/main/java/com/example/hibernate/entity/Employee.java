package com.example.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "employee")
@Data
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String company;

    public Employee(){

    }

    public Employee(String firstName, String lastName, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }
}
