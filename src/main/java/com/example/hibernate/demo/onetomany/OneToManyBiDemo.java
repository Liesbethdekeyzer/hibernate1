package com.example.hibernate.demo.onetomany;

import com.example.hibernate.entity.Course;
import com.example.hibernate.entity.Instructor;
import com.example.hibernate.entity.InstructorBi;
import com.example.hibernate.entity.InstructorDetail;
import com.example.hibernate.entity.InstructorDetailBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class OneToManyBiDemo {

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
/*            Instructor instructor = new Instructor("Susan", "Peeters", "Susan@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("youtube", "love 2 game");
            instructor.setInstructorDetail(instructorDetail);
            session.beginTransaction();
            session.save(instructor);*/

            session.beginTransaction();

            int instructorId = 1; //valid id

            Instructor instructor = session.get(Instructor.class, instructorId);
            System.out.println("adding a course");

            Course course = new Course("acou stic guitar");
            Course course2 = new Course("Hibernate");

            instructor.addCourse(course);
            instructor.addCourse(course2);

            session.save(course);
            session.save(course2);

            instructor = session.get(Instructor.class, instructorId);
            System.out.println("-------------------");

            System.out.println(instructor);

            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sessionFactory.close();
        }
    }

}
