package com.example.demohibernateapp.jdbc;

import com.example.demohibernateapp.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestJdbc {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class).
                buildSessionFactory()) {
            Session session = factory.openSession();
            Student student1 = new Student("Nikita", "Bezrodniy", "paul@luv2code.com");
            Student student2 = new Student("Egor", "Gavriliuk", "test@luv2code.com");
            Student student3 = new Student("Nastya", "Rodina", "test@luv2code.com");

            session.beginTransaction();
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.getTransaction().commit();

        }
    }
}
