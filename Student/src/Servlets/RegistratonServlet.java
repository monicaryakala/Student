package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RegistrationDAO;
import Model.RegistrationModel;

/**
 * Servlet implementation class RegistratonServlet
 */
@WebServlet("/RegistratonServlet")
public class RegistratonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistratonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegistrationDAO DAO = new RegistrationDAO();
		String username = request.getParameter("username");
		System.out.println(username+"==========-------------=========");
		String email = request.getParameter("email");
		System.out.println(email+"==========-------------=========");
		String pswd = request.getParameter("password");
		System.out.println(pswd+"==========-------------=========");
		RegistrationModel rm = new RegistrationModel();
		
		rm.setUsername(username);
		rm.setPassword(pswd);
		rm.setEmail(email);
		int k=DAO.registrationMethod(rm);
		if(k!=0){
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		else{
			request.setAttribute("error", "User already registered!!");
			RequestDispatcher rd=request.getRequestDispatcher("Registration.jsp");
			rd.forward(request, response);
		}
		
	
		
		
		doGet(request, response);
	}

}
