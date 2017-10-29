package com.example.hibernate.demo.eagervslazy;

import com.example.hibernate.entity.Course;
import com.example.hibernate.entity.Instructor;
import com.example.hibernate.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerVsLazyDemo {
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

            System.out.println("**********************************************");
            System.out.println("getting the instructor");

            Instructor instructor = session.get(Instructor.class, instructorId);

            System.out.println("demo instructor:" + instructor);
            System.out.println("getCourses");
//            session.getTransaction().commit();
            session.close();
            System.out.println("**********************************************");
            System.out.println("getting the COURSE");
            System.out.println("demo courses:" + instructor.getCourses());





        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sessionFactory.close();
        }
    }

}
