package com.example.hibernate.demo.onetomany;

import com.example.hibernate.entity.Course;
import com.example.hibernate.entity.Instructor;
import com.example.hibernate.entity.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;

public class oneToManyDeleteDemo {

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

            //get course
/*            int idCourse =13;
            Course course = session.get(Course.class, idCourse);
            System.out.println("deleting this course" + course);
            session.delete(course);*/

            Instructor instructor = session.get(Instructor.class, 1);
            System.out.println(instructor);

            //delete course

            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sessionFactory.close();
        }
    }

}
