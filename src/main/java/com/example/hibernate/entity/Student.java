package com.example.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "student")
@Data
@ToString
public class Student {

    @Id
    @GeneratedValue (strategy = IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "email")
    String email;


    public Student() {

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


}
