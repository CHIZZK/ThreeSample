package dao.impl;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import entity.Student;

public interface StudentDao {
	public boolean addStudent(Student student);

//查询某人是否存在
	public boolean isExist(int sno) ;

//查询全部学生
	public List<Student> queryAllStudent();
	// 根据学号查询学生
	public Student queryStudentBySno(int sno);

	// 根据学号删除学生
	public boolean deleteStudentBySno(int sno);

	// 根据学号修改学生：
	public boolean updateStudentBySno(int sno, Student student) ;

}
