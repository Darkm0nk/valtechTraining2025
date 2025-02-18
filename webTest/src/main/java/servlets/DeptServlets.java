package servlets;

import java.io.IOException;

import java.util.Iterator;
import java.util.List;

import org.eclipse.tags.shaded.org.apache.xpath.functions.FuncSubstring;

import dao.EmployeeInfo;
import services.departmentServices;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/depts")
public class DeptServlets extends HttpServlet {

	private DeptDAO deptDAO;
	private Dept dept;
	private departmentServices deptservice;
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext sc =config.getServletContext();
		deptDAO = new DepDaoImpl(sc);
		System.out.println("===");
//		deptDAO.save(new Dept(1,"HR","Blr"));
//		deptDAO.save(new Dept(2,"HR","Ahm"));
//		deptDAO.save(new Dept(3,"DEV","Blr"));
//		deptDAO.save(new Dept(4,"DEV","Ahm"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Dept current;
		
		//req.setAttribute("dept", deptDAO.first());
		
		HttpSession session = req.getSession();
		if(session.getAttribute("current")==null){
			 current = (Dept) deptDAO.first();
			 
			}else {
			 current = 	(Dept) session.getAttribute("current");
			}
		
		req.setAttribute("employeeByDept", deptDAO.getEmployeeByDeptsId(current.getId())); 
		
//		String sortingByParameter = req.getParameter("sortingByParameter");
		
		String column = req.getParameter("column"); // column to sort by
        String order = req.getParameter("order");
        
        if (column == null || order == null) {
            column = "id";
            order = "asc";
        }
        
       
	List<EmployeeInfo> employeeList=deptDAO.getEmployeeByDeptsId(current.getId());
		
//		if ("asc".equals(order)) {
//		    order = "desc"; // Change to descending if currently ascending
//		} else {
//		    order = "asc"; // Change to ascending if currently descending
//		}
//		
		List<EmployeeInfo> sortedEmployees = departmentServices.sortEmployees(employeeList,column, order);
//		 req.setAttribute("employee", deptDAO.sortEmployees(employeeList,column, order));
	        // Set sorted employee list as an attribute for JSP
	    req.setAttribute("employeeByDept", sortedEmployees);
	    req.setAttribute("current", current);
	    req.setAttribute("dept",current);
	    session.setAttribute("current", current);
	    System.out.println("Sorted Employees ::"+sortedEmployees);
	    session.setAttribute("employeeByDept", sortedEmployees);
		req.getRequestDispatcher("department.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		String searchName = req.getParameter("name");
		String searchAge = req.getParameter("age");
		String searchSalary = req.getParameter("salary");
		String searchExp = req.getParameter("exp");
		String searchLevel = req.getParameter("level");
		HttpSession session = req.getSession();
		Dept current = (Dept) session.getAttribute("current");
		List<EmployeeInfo> searchedEmployees;
		if (current == null) {
			current = deptDAO.first();
		} else {
			
			if ("First".equals(operation)) {
				current = deptDAO.first();
			} else if ("Last".equals(operation)) {
				current = deptDAO.last();
			} else if ("Previous".equals(operation)) {
				current = deptDAO.prev(current.getId());
			} else if ("Next".equals(operation)){
				current = deptDAO.next(current.getId());
			}
		}
		searchedEmployees = deptDAO.getEmployeeByDeptsId(current.getId());
		System.out.println("Search Age ::::"+ searchAge);
		if("search".equals(operation)) {
//			System.out.println("searchedEmployees :: " + searchedEmployees);
			if(searchName!=null) {
				searchedEmployees = searchedEmployees.stream().filter(e->e.getName().toLowerCase().contains(searchName)).toList();
			}
//			System.out.println("searchedEmployees :: " + searchedEmployees);
			if(!searchAge.isEmpty()) {
				if(searchAge.charAt(0)== '<') {
					String AgeInsSearchAge = searchAge.substring(1);
					System.out.println("age in searchAge < ::"+ AgeInsSearchAge);
					searchedEmployees = searchedEmployees.stream().filter(e->e.getAge() < Integer.parseInt(AgeInsSearchAge)).toList();
				}else if(searchAge.charAt(0)== '>') {
					String AgeInsSearchAge = searchAge.substring(1);
					System.out.println("age in searchAge > ::"+ AgeInsSearchAge);
					searchedEmployees = searchedEmployees.stream().filter(e->e.getAge() > Integer.parseInt(AgeInsSearchAge)).toList();
				}else {
					searchedEmployees = searchedEmployees.stream().filter(e->e.getAge()== Integer.parseInt(searchAge)).toList();
				}
				
			}
			
			if(!searchSalary.isEmpty()) {
				if(searchSalary.charAt(0)== '<') {
					String SalInSearch = searchSalary.substring(1);
					System.out.println("age in searchAge < ::"+ SalInSearch);
					searchedEmployees = searchedEmployees.stream().filter(e->e.getSalary() < Integer.parseInt(SalInSearch)).toList();
				}else if(searchSalary.charAt(0)== '>') {
					String SalInSearch = searchSalary.substring(1);
					System.out.println("age in searchAge > ::"+ SalInSearch);
					searchedEmployees = searchedEmployees.stream().filter(e->e.getSalary() > Integer.parseInt(SalInSearch)).toList();
				}else {
				searchedEmployees = searchedEmployees.stream().filter(e->e.getSalary()== Integer.parseInt(searchSalary)).toList();
				}
			}
			
			if(!searchExp.isEmpty()) {
				if(searchExp.charAt(0)== '<') {
					String SalInExp = searchExp.substring(1);
					System.out.println("age in searchAge < ::"+ SalInExp);
					searchedEmployees = searchedEmployees.stream().filter(e->e.getExp() < Integer.parseInt(SalInExp)).toList();
				}else if(searchExp.charAt(0)== '>') {
					String SalInExp = searchExp.substring(1);
					System.out.println("age in searchAge > ::"+ SalInExp);
					searchedEmployees = searchedEmployees.stream().filter(e->e.getExp() > Integer.parseInt(SalInExp)).toList();
				}else {
				searchedEmployees = searchedEmployees.stream().filter(e->e.getExp()== Integer.parseInt(searchExp)).toList();
				}
			}
			
			if(!searchLevel.isEmpty()) {
				if(searchLevel.charAt(0)== '<') {
					String SalInLevel = searchLevel.substring(1);
					System.out.println("age in searchAge < ::"+ SalInLevel);
					searchedEmployees = searchedEmployees.stream().filter(e->e.getLevel() < Integer.parseInt(SalInLevel)).toList();
				}else if(searchLevel.charAt(0)== '>') {
					String SalInLevel = searchLevel.substring(1);
					System.out.println("age in searchAge > ::"+ SalInLevel);
					searchedEmployees = searchedEmployees.stream().filter(e->e.getLevel() > Integer.parseInt(SalInLevel)).toList();
				}else {
				searchedEmployees = searchedEmployees.stream().filter(e->e.getLevel() == Integer.parseInt(searchLevel)).toList();
				}
			}
		}
		session.setAttribute("current", current);
		req.setAttribute("employeeByDept", searchedEmployees); 
		
		 //session.setAttribute("employeeByDept", );
		// Expressions in JSP can work with Object in Session also...
		req.setAttribute("dept", current);

		Cookie[] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			System.out.println(cookies[i].getName() + " " + cookies[i].getValue());
		}
		resp.addCookie(new Cookie("operation", operation));
		req.getRequestDispatcher("department.jsp").forward(req, resp);
	}
}
