package com.hibernate.deleteHibernate;

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
        

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        System.out.println("Welcome to Student management system");
        System.out.println("Enter id for the student to delete it.");
        
        int id = sc.nextInt();
        
        Student obj = session.get(Student.class, id);
        
        if (obj != null) {
        	session.remove(obj);
        	System.out.println("Deleted successfully !");
        } else {
        	System.out.println("Student not found with id " + id);
        }
        
        transaction.commit();
        session.close();
        factory.close();
        sc.close();
    }
}
