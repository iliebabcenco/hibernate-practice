package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            int studentId = 1;

            session.beginTransaction();

            System.out.println("Getting student with id: "+studentId);

            Student student = session.get(Student.class, studentId);

            System.out.println("Updating student...");

            student.setFirstName("Ilui");

            session.getTransaction().commit();

            session = factory.getCurrentSession();

            session.beginTransaction();

            System.out.println("Update mail for all students");

            session.createQuery("update Student set email='foo@gmail.com'")
                    .executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
        }

    }

}
