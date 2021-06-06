package com.src.lazyEager.HibernateLazyEager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.src.lazyEager.HibernateLazyEager.Model.Alien;
import com.src.lazyEager.HibernateLazyEager.Model.Laptop;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class)
				.addAnnotatedClass(Alien.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		Alien a1 = (Alien) session.get(Alien.class, 1);

		System.out.println(a1.getAname());
//        Collection<Laptop> laps = a1.getLaps();
//        
//        for(Laptop l : laps)
//        {
//        	System.out.println(l);
//        }

		session.getTransaction().commit();
	}
}
