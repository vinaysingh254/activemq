package com.vs.mq;

import javax.jms.JMSException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJMSListner {
	public static void main (String[] args) throws JMSException {
		System.out.println("LISTNER STARTED");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
	}
}
