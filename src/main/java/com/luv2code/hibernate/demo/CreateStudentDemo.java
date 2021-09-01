package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating the student instance");

            Student student = new Student("Paul", "Wall", "paul@luv2code.com");
            session.beginTransaction();
            System.out.println("Saving the student");
            session.save(student);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
        }

    }

}
