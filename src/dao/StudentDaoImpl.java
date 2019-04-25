package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.impl.StudentDao;
import entity.Student;

public class StudentDaoImpl implements StudentDao {
	Student student = null;
	Connection conn = null;
	PreparedStatement pre = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://localhost:3306/studentdemo";
	String name = "root";
	String password = "";
	List<Student> students = new ArrayList<Student>();

	// 添加学生
	public boolean addStudent(Student student) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, name, password);
			String sql = "insert into  student values(?,?,?,?)";
			pre = conn.prepareStatement(sql);
			pre.setInt(1, student.getSno());
			pre.setString(2, student.getSname());
			pre.setInt(3, student.getSage());
			pre.setString(4, student.getSaddress());
			int re = pre.executeUpdate();
			if (re > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pre != null) {
					pre.close();
				}
				if (pre != null) {
					pre.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
	}

//查询某人是否存在
	public boolean isExist(int sno) {
		return queryStudentBySno(sno) == null ? false : true;
	}

//查询全部学生
	public List<Student> queryAllStudent() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, name, password);
			String sql = "select * from student ";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
				students.add(student);
			}
			return students;
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return null;
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pre != null) {
					pre.close();
				}
				if (pre != null) {
					pre.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	// 根据学号查询学生
	public Student queryStudentBySno(int sno) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, name, password);
			String sql = "select * from student where  sno=?";
			pre = conn.prepareStatement(sql);
			pre.setInt(1, sno);
			rs = pre.executeQuery();
			if (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
			}
			return student;
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return null;
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pre != null) {
					pre.close();
				}
				if (pre != null) {
					pre.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	// 根据学号删除学生
	public boolean deleteStudentBySno(int sno) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, name, password);
			String sql = "delete  from student where sno=?";
			pre = conn.prepareStatement(sql);
			pre.setInt(1, sno);
			int re = pre.executeUpdate();
			if (re > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pre != null) {
					pre.close();
				}
				if (pre != null) {
					pre.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();

			}
		}
	}

	// 根据学号修改学生：
	public boolean updateStudentBySno(int sno, Student student) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, name, password);
			String sql = "update student set sname=?, sage=?,saddress=? where sno=?";
			pre = conn.prepareStatement(sql);

			pre.setString(1, student.getSname());
			pre.setInt(2, student.getSage());
			pre.setString(3, student.getSaddress());
			pre.setInt(4, sno);
			int re = pre.executeUpdate();

			if (re > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pre != null) {
					pre.close();
				}
				if (pre != null) {
					pre.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
	}

}
