package ch.qiminfo.demo.webapp.servlet;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ch.qiminfo.demo.database.init.IDataInit;

/**
 *	Temporary way to populate H2 database
 */
public class InitServlet implements ServletContextListener{
	
	@EJB
	IDataInit dataInit;

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		dataInit.initializeData();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
	        /* Do Shutdown stuff. */
	}

}