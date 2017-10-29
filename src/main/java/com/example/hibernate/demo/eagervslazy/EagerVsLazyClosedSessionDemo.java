package com.example.hibernate.demo.eagervslazy;

import com.example.hibernate.entity.Course;
import com.example.hibernate.entity.Instructor;
import com.example.hibernate.entity.InstructorDetail;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

public class EagerVsLazyClosedSessionDemo {

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

            List instructorQuery = session.createQuery("select i from Instructor i"
                                                       + " Join FETCH i.courses "
                                                       + " where i.id=:instructorId")
                .setParameter("instructorId", instructorId).list();

            instructorQuery.forEach(i -> System.out.println(i));
            System.out.println("**********************************************");


            /*Instructor instructor = session.get(Instructor.class, instructorId);

            System.out.println("demo instructor:" + instructor);

            session.getTransaction().commit();
            instructor.getCourses();

            session.close();

            System.out.println("getCourses");
            System.out.println("**********************************************");
            System.out.println("getting the instructor");
            System.out.println("demo courses:" + instructor.getCourses());

            session.getTransaction().commit();*/

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sessionFactory.close();
        }
    }

}
