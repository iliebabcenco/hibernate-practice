package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating the student instance");

            Student student = new Student("Daffy", "Duck", "dack@luv2code.com");
            session.beginTransaction();
            System.out.println("Saving the student");
            System.out.println(student);
            System.out.println(session);
            session.save(student);

            session.getTransaction().commit();
            System.out.println("Student saved with Generated id: "+student.getId());


            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Getting student with id: "+student.getEmail());

            Student student1 = session.get(Student.class, student.getId());

            System.out.println("Got the student: ");
            System.out.println(student1);

            System.out.println("Done!");

        } finally {
            session.close();
        }

    }

}
