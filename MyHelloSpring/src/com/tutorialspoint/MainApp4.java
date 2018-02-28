package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp4 {
	public static void main(String[] args) {
	      ApplicationContext context = 
	             new ClassPathXmlApplicationContext("Beans3.xml");
	      Student student = (Student) context.getBean("student");
	      student.getName();
	      student.getAge();      
	      student.printThrowException();
	       
	   }
}
