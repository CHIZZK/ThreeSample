package service;

import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import dao.StudentDaoImpl;
import entity.Student;

//业务逻辑层
public interface StudentService {
	StudentDaoImpl studentDao = new StudentDaoImpl();

	// 增
	public boolean addStudent(Student student) ;
	

	// 删
	public boolean deleteStudentBySno(int sno) ;

	// 改：根据学号修改
	public boolean updateStudentBySno(int sno, Student student) ;

	// 查：根据学号查询一个人
	public Student queryStduentBySno(int sno) ;
	
	// 查询全部学生
	public List<Student> queryAllStudent() ;
	

}
