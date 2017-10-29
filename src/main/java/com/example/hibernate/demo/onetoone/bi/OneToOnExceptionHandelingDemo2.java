package com.example.hibernate.demo.onetoone.bi;

import com.example.hibernate.entity.Instructor;
import com.example.hibernate.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class OneToOnExceptionHandelingDemo2 {

    public static void main(String[] args) {
        //get session factory

        SessionFactory sessionFactory =
            new Configuration().configure("hibernate3.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            //create objects
            Instructor instructor = new Instructor("Liesbeth", "de Keyzer", "Liesbeth@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("someChannel", "love 2 code");

            //associate the objects
            instructor.setInstructorDetail(instructorDetail);

            //start transaction
            session.beginTransaction();
            session.save(instructor); //this wil also sanve the details >> cascadetype All
            session.getTransaction().commit();

            //comit

        } finally {
            sessionFactory.close();
        }
    }

}
