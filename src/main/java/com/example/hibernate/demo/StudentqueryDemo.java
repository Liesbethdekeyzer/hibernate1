package com.example.hibernate.demo;

import com.example.hibernate.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentqueryDemo {

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
            Student myStudent = session.get(Student.class, 5);
            System.out.println(myStudent.toString());
            System.out.println("-------------------------------------------------------");
            List<Student> theStudents = (List<Student>) session.createQuery("from Student s where s.lastName= 'deKeyzer'").list();
            theStudents.forEach(s -> System.out.println(s));
            System.out.println("-------------------------------------------------------");


        } finally {
            sessionFactory.close();
        }
    }


}
