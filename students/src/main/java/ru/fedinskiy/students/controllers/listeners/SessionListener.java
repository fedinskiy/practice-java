package ru.fedinskiy.students.controllers.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by fedinskiy on 24.02.17.
 */
public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener {
	Logger logger = LogManager.getLogger(SessionListener.class);
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		logger.trace(se.getSession().getId());
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		logger.trace(event.getName()+" "+event.getValue());
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
	}
	
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}
}
