package com.example.demohibernateapp.jdbc;

import com.example.demohibernateapp.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class).
                buildSessionFactory()) {

            Session session = factory.openSession();

            session.beginTransaction();

            List<Student> theStudents = session.createQuery("from Student s where s.lastName='Wall'" +
                    "OR s.firstName='Egor' OR s.email LIKE '%luv2code.com'").getResultList();

            theStudents.forEach(System.out::println);

            // Update students example
            theStudents.forEach(st -> {
                if (st.getFirstName().equals("Egor"))
                    st.setEmail("gavrilyk2903@gmail.com");
            });

            // Update all students emails
            //session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();

        }
    }
}
