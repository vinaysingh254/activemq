package com.vs.mq;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageReceiver implements MessageListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiver.class);

	public void onMessage (final Message message) {
		LOGGER.info("Message received.....");
		if (message instanceof MapMessage) {
			final MapMessage mapMessage = (MapMessage)message;
			LOGGER.info("Message received.." + mapMessage);
		}
		if (message instanceof TextMessage) {
			try {
				final TextMessage textMessage = (TextMessage)message;
				LOGGER.info("Message received.." + textMessage.getText());
			} catch (JMSException e) {
				LOGGER.info("error receving message", e);
			}
		}
	}
}
