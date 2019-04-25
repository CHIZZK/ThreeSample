package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import service.StudentService;
import service.StudentServiceImpl;


@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//删除
		request.setCharacterEncoding("utf-8");
		//接收前端传来的学号
		int sno=Integer.parseInt(request.getParameter("sno"));
		StudentService  service=new  StudentServiceImpl();
		boolean result=service.deleteStudentBySno(sno);
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		if (result) {
//			response.getWriter().println("删除成功");
			response.sendRedirect("QueryAllStudentServlet");//重新查询所有学生
		}else {
			response.getWriter().println("删除失败");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
