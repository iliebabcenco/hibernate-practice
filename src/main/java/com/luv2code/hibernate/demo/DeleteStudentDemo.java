package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            int studentId = 2;

            session.beginTransaction();

            System.out.println("Getting student with id: "+studentId);

            Student student = session.get(Student.class, studentId);

            System.out.println("Deleting student with id..."+student.getId());

//            session.delete(student);

            session.createQuery("delete from Student where id=2").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
        }

    }

}
