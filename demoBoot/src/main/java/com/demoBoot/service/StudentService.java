package com.demoBoot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoBoot.dao.StudentDao;
import com.demoBoot.dao.StudentSubjectDao;
import com.demoBoot.dao.StudentTeacherDao;
import com.demoBoot.dto.StudentDto;
import com.demoBoot.entity.Student;
import com.demoBoot.entity.StudentTeacher;
import com.demoBoot.setter.StudnetSetter;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private StudentTeacherDao studentTeacherDao;
	@Autowired
	private StudentSubjectDao studentSubjectDao;

	public void saveStudent(StudentDto dto) {

		studentDao.save(StudnetSetter.setStudentEntity(dto));

	}

	public List<StudentDto> getAllStudents() {

		List<Student> list = studentDao.findAll();
		List<StudentDto> l1 = new ArrayList<>();
		list.forEach((e) -> {
			l1.add(StudnetSetter.setStudentDto(e));
		});

		return l1;
	}

	public String  deleteStudent(int id) {
		
		studentTeacherDao.deleteRowBySudentId(id);
		studentSubjectDao.deleteRowBySudentId(id);
		studentDao.deleteById(id);
		
			
			return "Student deleted";
		
	}

	public boolean updateStudent(int id, StudentDto dto) {

		Student st = StudnetSetter.setStudentEntity(id, dto);

		System.out.println(st);

		studentDao.save(st);

		return true;

	}

	public List<StudentDto> getStudentsByTeacherId(int id) {

		List<Student> list = studentDao.getStudentsByTeacherId(id);

		List<StudentDto> l1 = new ArrayList<>();
		list.forEach((e) -> {
			l1.add(StudnetSetter.setStudentDto(e));
		});

		return l1;
	}

}
