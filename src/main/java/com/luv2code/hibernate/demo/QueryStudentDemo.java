package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Student> studentList = session.createQuery("from Student ").getResultList();

            displayStudents(studentList);

            studentList = session.createQuery("from Student s where s.lastName='Duck'").getResultList();

            displayStudents(studentList);

            studentList = session.createQuery("from Student s where s.firstName like '%f' or s.lastName='Duck'").getResultList();

            displayStudents(studentList);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
        }

    }

    private static void displayStudents(List<Student> studentList) {
        for (Student student: studentList) {
            System.out.println(student);
        }
    }

}
