package com.example.hibernate.demo.onetoone.bi;

import com.example.hibernate.entity.InstructorBi;
import com.example.hibernate.entity.InstructorDetailBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class OneToOneBiDirDeleteDemo {

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

            int instructorDetailId = 3; //valid id

            InstructorDetailBi instructorDetailBi = session.get(InstructorDetailBi.class, instructorDetailId);

            System.out.println("Printing the instructorDetail");
            System.out.println(instructorDetailBi);
            System.out.println("Printing the instructor");
            System.out.println(instructorDetailBi.getInstructorBi());
            System.out.println("Delete instructorDetail");

            instructorDetailBi.getInstructorBi().setInstructorDetailBi(null);

            session.delete(instructorDetailBi);

            session.getTransaction().commit();

            //comit

        } catch(Exception e){
            e.printStackTrace();

        } finally{
            sessionFactory.close();
        }
    }

}
