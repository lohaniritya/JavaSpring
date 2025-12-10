package com.hibernate.updateHibernate;

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
        

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        
        SessionFactory factory = configuration.buildSessionFactory();
        
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        System.out.println("Welcome to Student management system");
        System.out.println("Enter id for the student to update its marks and name.");
        
        int id = sc.nextInt();
        sc.nextLine();
        
        Student obj = session.get(Student.class, id);
        
        if (obj != null) {
        	System.out.println("Enter new name and email.");
        	String name = sc.next();
        	int marks = sc.nextInt();
        	obj.setName(name);
        	obj.setMarks(marks);
        	session.persist(obj);
        	System.out.println("Updated successfully !");
        } else {
        	System.out.println("Student not found with id " + id);
        }
        
        transaction.commit();
        session.close();
        factory.close();
        sc.close();
    }
}
