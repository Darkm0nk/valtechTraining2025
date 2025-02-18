package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	//don't write your own constructor // parameterless constructor by default
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String company = config.getInitParameter("company");
		System.out.println("Init...."+ company);
		super.init();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println("SERVICE....");
		PrintWriter out = res.getWriter();
		out.println("Hello" + name + "!");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy....");
	}
}
