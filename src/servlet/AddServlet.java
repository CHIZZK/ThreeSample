package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Student;
import service.StudentService;
import service.StudentServiceImpl;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html; charset=UTF-8");
		 int   no=Integer.parseInt(request.getParameter("sno"));
		 String  name=request.getParameter("sname");
		 int   age=Integer.parseInt(request.getParameter("sage"));
		 String  address=request.getParameter("saddress");
		 Student  student=new Student(no,name,age,address);
		 StudentService  studentServlce=new StudentServiceImpl();
		 boolean  result=studentServlce.addStudent(student);
		// PrintWriter  out=response.getWriter();
		 if (!result) {
//			out.print("success");
			 request.setAttribute("error", "error");
//			 response.sendRedirect("QueryAllStudentServlet");
		}else {
//			out.print("error");
			 request.setAttribute("error", "noerror");
			 
//			 response.sendRedirect("QueryAllStudentServlet");
//			request.getRequestDispatcher("index.jsp").forward(request, response);
			request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);
		}
		 
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
}
}