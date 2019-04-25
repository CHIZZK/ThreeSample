package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Student;
import service.StudentService;
import service.StudentServiceImpl;

@WebServlet("/QueryStudentBySnoServlet")
public class QueryStudentBySnoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no=Integer.parseInt(request.getParameter("sno"));
		StudentService  service=new StudentServiceImpl();
		Student student=service.queryStduentBySno(no);
		System.out.println(student);
		//将此人的数据通过前台jsp显示  studentInfo.jsp
		request.setAttribute("student", student);
		request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
