package com.example.demohibernateapp.jdbc;

import com.example.demohibernateapp.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class).
                buildSessionFactory()) {

            Session session = factory.openSession();

            session.beginTransaction();
            Student student = session.get(Student.class, 4);

            System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());

            // Deleting student
            session.delete(student);

            // Delete using query
            //session.createQuery("delete from Student where id=4").executeUpdate();

            session.getTransaction().commit();

        }
    }
}
