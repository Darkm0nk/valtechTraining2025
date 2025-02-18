package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class LoadConfigListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext application = sce.getServletContext();
		Properties properties = new Properties();
		
		InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
		if(input!=null) {
			try {
				properties.load(input);
				application.setAttribute("url", properties.getProperty("jdbc.url"));
				application.setAttribute("user", properties.getProperty("jdbc.username"));
				application.setAttribute("pass", properties.getProperty("jdbc.password"));
				String driver = properties.getProperty("jdbc.driver");
//				System.out.println("properties.getProperty(\"jdbc.url\")"+driver);
				Class.forName(driver);
			} catch (IOException | ClassNotFoundException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Closing all Database Connection in Connection Pools ....");
	}
	
}
