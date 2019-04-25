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

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no=Integer.parseInt(request.getParameter("sno"));
		String name=request.getParameter("sname");
		int   age  =Integer.parseInt(request.getParameter("sage"));
		String address=request.getParameter("saddress");
		Student  student=new Student(name,age,address);
		StudentService  service=new StudentServiceImpl();
		boolean result=service.updateStudentBySno(no, student);
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		if (result) {
//			response.getWriter().println("修改成功");
			response.sendRedirect("QueryAllStudentServlet");//修改完畢，返回查詢
		}else {
			response.getWriter().println("修改失败");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
