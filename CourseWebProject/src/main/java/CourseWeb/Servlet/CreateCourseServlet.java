package CourseWeb.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CourseWeb.Dao.CourseDao;
import CourseWeb.Dao.DaoInterface;
import CourseWeb.beans.CourseProject;

/**
 * Servlet implementation class CreateCourseServlet
 */
@WebServlet(name = "createCourse", urlPatterns = { "/createCourse" })
public class CreateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text.html");
		PrintWriter out = response.getWriter();
		
		//Capturing CourseProject specific information:
		String cId = request.getParameter("courseId");
		String cTitle = request.getParameter("courseTitle");
		String cDuration = request.getParameter("courseDuration");
		String cProvider = request.getParameter("courseProvider");
		String cFees = request.getParameter("courseFees");
		
		//Converting the Strings into Integers as required
		int c_id = Integer.parseInt(cId);
		int c_duration = Integer.parseInt(cDuration);
		int c_fees = Integer.parseInt(cFees);
		
		//Populating a CourseProject object based upon the information coming from client
		CourseProject cst = new CourseProject(c_id, cTitle, c_duration, cProvider, c_fees);
		
		//Populating RestaurantDao object to perform Record Insertion
		DaoInterface<CourseProject, Integer> idao = new CourseDao();
		
		//Invoking 'create()' method to insert the record
		idao.create(cst);
		out.println("<h1>Course Created successfully..</h1>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
