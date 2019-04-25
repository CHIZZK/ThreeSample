package service;

import java.util.List;
import dao.StudentDaoImpl;
import dao.impl.StudentDao;
import entity.Student;

public class StudentServiceImpl  implements  StudentService{

	// 业务逻辑层
		StudentDao studentDao = new StudentDaoImpl();

		// 增
		public boolean addStudent(Student student) {
			if (!studentDao.isExist(student.getSno())) {
				return studentDao.addStudent(student);

			} else {
				return false;
			}

		}

		// 删
		public boolean deleteStudentBySno(int sno) {
			if (studentDao.isExist(sno)) {
				return studentDao.deleteStudentBySno(sno);
			} else {
				return false;
			}

		}

		// 改：根据学号修改
		public boolean updateStudentBySno(int sno, Student student) {
			if (studentDao.isExist(sno)) {
				return studentDao.updateStudentBySno(sno, student);
			} else {
				return false;
			}

		}

		// 查：根据学号查询一个人
		public Student queryStduentBySno(int sno) {
			return studentDao.queryStudentBySno(sno);
		}

		// 查询全部学生
		public List<Student> queryAllStudent() {
			return studentDao.queryAllStudent();
		}

	}
