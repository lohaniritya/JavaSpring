package com.hibernate.firstHibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to Student management system");
        System.out.println("Enter name, marks, email for the student");
        String n = sc.next();
        int m = sc.nextInt();
        String g = sc.next();
        Student s1 = new Student(n, m, g);
        
        
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        
        SessionFactory factory = configuration.buildSessionFactory();
        
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.persist(s1);
        
        transaction.commit();
        
        session.close();
        factory.close();
        
        sc.close();
    }
}
