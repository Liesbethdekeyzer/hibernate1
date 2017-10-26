package com.example.hibernate.demo;

import com.example.hibernate.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

@SuppressWarnings("JpaQlInspection")
public class StudentDeleteDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
            .configure()
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("-------------------------------------------------------");
            Student myStudent = session.get(Student.class, 3);
            System.out.println(myStudent.toString());
            session.delete(myStudent);
            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }
    }


}
