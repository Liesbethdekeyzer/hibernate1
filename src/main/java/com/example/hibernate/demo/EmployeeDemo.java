package com.example.hibernate.demo;


import com.example.hibernate.entity.Employee;
import com.example.hibernate.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.LinkedList;
import java.util.List;

public class EmployeeDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
            .configure("hibernate2.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .buildSessionFactory();

        try {
         /*   saveEmployees(sessionFactory);

            readEmployeeWithId(sessionFactory, 4);*/

            //readEmployeeThatWorkForCompany(sessionFactory, "lightspeed");

            deleteEmployeeWithId(sessionFactory, 5);


        } finally {
            sessionFactory.close();
        }
    }

    private static void deleteEmployeeWithId(SessionFactory sessionFactory, int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
/*        Employee employee = readEmployeeWithId(sessionFactory,i);
        System.out.println("beginning the transaction");
        session.delete(employee);
        session.getTransaction().commit();*/
        session.createQuery("delete Employee e where e.id=:id").setParameter("id", id).executeUpdate();
        session.getTransaction().commit();
    }

    private static void readEmployeeThatWorkForCompany(SessionFactory sessionFactory, String companyName) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        System.out.println("beginning the transaction");
        List<Employee> read =
            session.createQuery("from Employee e where e.company=:companyName")
                .setParameter("companyName", companyName)
                .list();
        read.forEach(e -> System.out.println(e));
        System.out.println("reading entity with id 1 :" + read.toString());
    }

    private static Employee readEmployeeWithId(SessionFactory sessionFactory, int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        System.out.println("beginning the transaction");
        System.out.println("reading entity with id " + id);

        Employee read = session.get(Employee.class, id);
        System.out.println("reading entity with id 1 :" + read.toString());
        return read;
    }

    private static void saveEmployees(SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        System.out.println("beginning the transaction");

        Employee employee1 = new Employee("Jonas", "ostir", "Lightspeed");
        Employee employee2 = new Employee("Liesbeth", "de Keyzer", "Lightspeed");
        Employee employee3 = new Employee("Joris", "De smet", "showpad");
        Employee employee4 = new Employee("Sarah", "de Keyzer", "Orbit");
        System.out.println("saving the employees");
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        session.save(employee4);
        System.out.println("commit");
        session.getTransaction().commit();
    }


}
