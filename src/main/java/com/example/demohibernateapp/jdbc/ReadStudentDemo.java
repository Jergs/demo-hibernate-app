package com.example.demohibernateapp.jdbc;

import com.example.demohibernateapp.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadStudentDemo {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class).
                buildSessionFactory()) {

            Session session = factory.openSession();

            session.beginTransaction();
            Student student = session.get(Student.class, 1);

            System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());

            // HQL example
            List<Student> theStudents = session.createQuery("from Student s where s.lastName='Wall'" +
                    "OR s.firstName='Egor' OR s.email LIKE '%luv2code.com'").getResultList();

            theStudents.forEach(System.out::println);

            session.getTransaction().commit();

        }
    }
}
