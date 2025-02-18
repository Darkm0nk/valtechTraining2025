package servlets;

import java.io.IOException;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import dao.EmployeeInfo;
import dao.EmployeeInfo.Gender;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/employees")
public class EmployeesServlet extends HttpServlet {
	
	private EmployeeDAO dao;
	
	@Override
	public void init() throws ServletException {
		dao = new EmployeeDAOImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		if("Update".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			EmployeeInfo e = dao.get(id);
			req.setAttribute("emp", e);
			req.setAttribute("check", 0);
			req.setAttribute("mode", "Update");
			req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
		}
		
		if("Delete".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			dao.delete(id);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("new".equals(operation)) {
			req.setAttribute("mode", "Save");
			req.setAttribute("check", 1);
			req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
			return;
		}
		req.setAttribute("emps", dao.getAll());
		req.getRequestDispatcher("employees.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		if("Cancel".equals(operation)) {
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		EmployeeInfo emp = EmployeeInfo.builder().id(Integer.parseInt(req.getParameter("id")))
				.name(req.getParameter("name"))
				.age(Integer.parseInt(req.getParameter("age")))
				.gender(Gender.valueOf(req.getParameter("gender").toUpperCase()))
				.salary(Integer.parseInt(req.getParameter("salary")))
				.exp(Integer.parseInt(req.getParameter("experience")))
				.level(Integer.parseInt(req.getParameter("level")))
				.departmentId(Integer.parseInt(req.getParameter("departmentId"))).build();
		if("Save".equals(operation)){
			dao.save(emp);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("Update".equals(operation)){
			dao.update(emp);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		
	}
	
}
