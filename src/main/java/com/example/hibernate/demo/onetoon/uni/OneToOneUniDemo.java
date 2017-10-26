package com.example.hibernate.demo.onetoon.uni;

import com.example.hibernate.entity.Instructor;
import com.example.hibernate.entity.InstructorBi;
import com.example.hibernate.entity.InstructorDetail;
import com.example.hibernate.entity.InstructorDetailBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class OneToOneUniDemo {

    public static void main(String[] args) {
        //get session factory

        SessionFactory sessionFactory =
            new Configuration().configure("hibernate3.cfg.xml")
                .addAnnotatedClass(InstructorDetailBi.class)
                .addAnnotatedClass(InstructorBi.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            //start transaction
            session.beginTransaction();
            //get the objects

            InstructorDetailBi instructorDetailBi = session.get(InstructorDetailBi.class, 1);

            System.out.println("Printing the instructorDetail");
            System.out.println(instructorDetailBi);
            System.out.println("Printing the instructor");
            System.out.println(instructorDetailBi.getInstructorBi());

            session.getTransaction().commit();

            //comit

        } finally {
            sessionFactory.close();
        }
    }

}
