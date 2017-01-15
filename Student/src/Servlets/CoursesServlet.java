package Servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.CoursesDAO;
import DAO.MaterialDAO;
import Model.CoursesModel;
import Model.MaterialModel;

/**
 * Servlet implementation class CoursesServlet
 */
@WebServlet("/CoursesServlet")
public class CoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoursesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get values of text fields
		String courseid = request.getParameter("courseid");
		System.out.println(courseid);
		String coursename = request.getParameter("coursename");
		System.out.println(coursename);
		String coursecontent = request.getParameter("coursecontent");
		System.out.println(coursecontent);
		String materialname = request.getParameter("materialname");
		System.out.println(materialname);
		InputStream inputStream = null; // input stream of the upload file
		
		 // obtains the upload file part in this multipart request
        Part filePart = request.getPart("material");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
       
        }
		//calling model class
		CoursesModel coursesmodel = new CoursesModel();
		//setting the parameters to model class
		coursesmodel.setCourseId(courseid);
		coursesmodel.setCourseName(coursename);
		coursesmodel.setCourseContent(coursecontent);
		
		//calling material class
		MaterialModel materialmodel = new MaterialModel();
		materialmodel.setFilename(materialname);
		materialmodel.setInputstream(inputStream);
		materialmodel.setContenttype(filePart.getContentType());
		
		//afer setting the values call send the values to db
	
		CoursesDAO coursesdao = new CoursesDAO();
		coursesdao.addCourses(coursesmodel);
	
		MaterialDAO materialdao = new MaterialDAO();
		materialdao.fileupload(materialmodel, coursesmodel);
		/*
		//calling DAO class
		CoursesDAO coursesdao = new CoursesDAO();
		//setting model class as a parameter to DAO class
		int k = coursesdao.addCourses(coursesmodel);
		System.out.println(k);
		if(k!=0){
			request.setAttribute("addcourse", "course added successfully");
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}else{
			request.setAttribute("error", "enter valid details");
			RequestDispatcher rd=request.getRequestDispatcher("AddCourses.jsp");
			rd.forward(request, response);
		}
		doGet(request, response);
		*/
	}

}
