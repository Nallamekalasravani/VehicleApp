package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
        SessionFactory factory = cfg.buildSessionFactory();  

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Car car = new Car();
        car.setName("Sedan");
        car.setType("Car");
        car.setMaxSpeed(180);
        car.setColor("Red");
        car.setNumberOfDoors(4);  

        Truck truck = new Truck();
        truck.setName("Cargo Truck");
        truck.setType("Truck");
        truck.setMaxSpeed(100);
        truck.setColor("Blue");
        truck.setLoadCapacity(20000);  

        session.persist(car); 
        session.persist(truck);  

        tx.commit();  
        session.close(); 

        factory.close();
        System.out.println("Records inserted successfully!");
    }
}

