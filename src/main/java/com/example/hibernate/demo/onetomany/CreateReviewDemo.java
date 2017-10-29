package com.example.hibernate.demo.onetomany;

import com.example.hibernate.entity.Course;
import com.example.hibernate.entity.Instructor;
import com.example.hibernate.entity.InstructorDetail;
import com.example.hibernate.entity.Review;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateReviewDemo {

    public static void main(String[] args) {
        //get session factory

        SessionFactory sessionFactory =
            new Configuration().configure("hibernate5.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        //get session factory

        Session session = sessionFactory.getCurrentSession();
        try {
            //create objects
            //start transaction
            session.beginTransaction();
            deleteTheCourse(session, 10);
            session.getTransaction().commit();

            //comit

        } finally {
            sessionFactory.close();
        }
    }

    private static void getCourseAndPrint(Session session, int courseId) {
        System.out.println("getting the course");
        Course course = session.get(Course.class, courseId);
        System.out.println("printing course: " + course);
        System.out.println("printing the reviews ===> lazy loading");
        System.out.println("printing reviews: " + course.getReviews());

    }

    private static void deleteTheCourse(Session session, int courseId) {
        System.out.println("getting the course");
        Course course = session.get(Course.class, 10);
        session.delete(course);


    }

    private static int insertCourseWithReviews(Session session) {
        Course tempCourse = new Course("starting hibernate");
        tempCourse.addReview(new Review("great!"));
        tempCourse.addReview(new Review("te best"));
        tempCourse.addReview(new Review("could be better"));
        //saving the course and all the reviews
        session.save(tempCourse);
        return tempCourse.getId();
    }

}
