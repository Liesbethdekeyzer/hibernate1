package com.example.hibernate.demo;

import com.example.hibernate.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class StudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
            .configure()
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Student student = new Student("amelie", "deKeyzer", "amelie@gmail.com");
            Student student2 = new Student("Sarah", "deKeyzer", "Sarah@gmail.com");

            session.beginTransaction();

            session.save(student);
            session.save(student2);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }

}
