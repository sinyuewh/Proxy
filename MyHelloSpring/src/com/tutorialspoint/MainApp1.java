package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp1 {
	public static void main(String[] args) {
		   ApplicationContext ctx = 
		   new AnnotationConfigApplicationContext(HelloWorldConfig.class); 
		   HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		   helloWorld.setMessage("Hello World!");
		   helloWorld.getMessage();
		}
}
