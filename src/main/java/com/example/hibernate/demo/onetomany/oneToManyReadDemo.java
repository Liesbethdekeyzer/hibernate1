package com.example.hibernate.demo.onetomany;

import com.example.hibernate.entity.Course;
import com.example.hibernate.entity.Instructor;
import com.example.hibernate.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class oneToManyReadDemo {
    public static void main(String[] args) {
        //get session factory

        SessionFactory sessionFactory =
            new Configuration().configure("hibernate4.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            int instructorId = 1; //valid id

            Instructor instructor = session.get(Instructor.class, instructorId);
            System.out.println(instructor);
            System.out.println("getCourses");
            System.out.println(instructor.getCourses());



            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sessionFactory.close();
        }
    }

}
