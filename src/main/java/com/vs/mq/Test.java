package com.vs.mq;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main (String[] args) {
		// init spring context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
		// get bean from context
		JmsMessageSender jmsMessageSender = (JmsMessageSender)ctx.getBean("jmsMessageSender");
		// send to default destination
		jmsMessageSender.send("Message Sending to JMS listener.....");
		// send to a code specified destination
		Queue queue = new ActiveMQQueue("AnotherDest");
		jmsMessageSender.send(queue, "hello Another Message");
		// close spring application context
		((ClassPathXmlApplicationContext)ctx).close();
	}
}
