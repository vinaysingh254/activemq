package com.vs.mq;

import java.util.Map;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/** @author Vinay Singh */
public class JmsMessageSender {
	@Autowired private JmsTemplate jmsTemplate;

	public void send (final String string) {
		MessageCreator mssage = new MessageCreator() {
			public Message createMessage (Session session) throws JMSException {
				Message message = session.createTextMessage(string);
				// set ReplyTo header of Message, pretty much like the concept of email.
				message.setJMSReplyTo(new ActiveMQQueue("Send2Recv"));
				return message;
			}
		};
		this.jmsTemplate.send(mssage);
	}

	public void sendText (final String text) {
		this.jmsTemplate.convertAndSend(text);
	}

	public void send (final Destination dest, final String text) {
		this.jmsTemplate.send(dest, new MessageCreator() {
			public Message createMessage (Session session) throws JMSException {
				Message message = session.createTextMessage(text);
				return message;
			}
		});
	}
}
