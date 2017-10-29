package com.example.hibernate.demo.onetoone.bi;

import com.example.hibernate.entity.InstructorBi;
import com.example.hibernate.entity.InstructorDetailBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class OneToOneBiDirDemo {

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

            int wrongId = 999;

            InstructorDetailBi instructorDetailBi = session.get(InstructorDetailBi.class, wrongId);

            System.out.println("Printing the instructorDetail");
            System.out.println(instructorDetailBi);
            System.out.println("Printing the instructor");
            System.out.println(instructorDetailBi.getInstructorBi());

            session.getTransaction().commit();

            //comit

        } catch(Exception e){
            e.printStackTrace();

        } finally{
            session.close();
            sessionFactory.close();
        }
    }

}
