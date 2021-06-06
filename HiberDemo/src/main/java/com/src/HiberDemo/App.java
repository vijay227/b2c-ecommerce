package com.src.HiberDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		//Reddy1-12			
		Student student = new Student();

		student.setId(1);
		student.setName("vijay");
		student.setAddress("pune");

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class);

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();

		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

//		session.save(student);
//		System.out.println("data saved");
//		data retrival

		student = (Student) session.get(Student.class, 1);
		tx.commit();
		System.out.println(student);

	}
}
