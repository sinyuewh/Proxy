package com.tutorialspoint;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.beans.BeansException;

public class InitHelloWorld1 implements BeanPostProcessor, Ordered {
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeforeInitialization ----1: " + beanName);
		return bean; // you can return any other object as well
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("AfterInitialization ---1: " + beanName);
		return bean; // you can return any other object as well
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 2;
	}
}
