package com.demoBoot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoBoot.dao.StudentTeacherDao;
import com.demoBoot.dao.SubjectTeacherDao;
import com.demoBoot.dao.TeacherDao;
import com.demoBoot.dto.TeacherDto;
import com.demoBoot.entity.StudentTeacher;
import com.demoBoot.entity.Teacher;
import com.demoBoot.setter.TeacherSetter;

@Service
@Transactional
public class TeacherService {
	@Autowired
	private TeacherDao dao;

	@Autowired
	private StudentTeacherDao studentTeacherDao;

	@Autowired
	private SubjectTeacherDao subjectTeacherDao;

	public boolean addTeacher(TeacherDto dto) {

		Teacher teacher = TeacherSetter.setTecher(dto);

		Teacher t = dao.save(teacher);
		if (t.equals(null)) {
			return false;
		}

		else {
			return true;
		}
	}

	public List<TeacherDto> getTeachers() {

		List<Teacher> list = dao.findAll();

		List<TeacherDto> l1 = new ArrayList<>();
		list.forEach((e) -> {
			l1.add(TeacherSetter.setDto(e));
		});

		return l1;

	}

	public String deleteTeacher(int id) {
	     
			studentTeacherDao.deleteRowByTeacherId(id);
			subjectTeacherDao.deleteRowByTeacherId(id);
			dao.deleteById(id);
		
			return "teacher deleted";

	
	}

	public String updateTeacher(int id, TeacherDto dto) {
		try {
			Teacher t = dao.getById(id);

			if (t.equals(null)) {
				return "Teacher doen't exist";

			} else {
				dao.save(TeacherSetter.setTecher(id, dto));
				return "Teacher updated ";
			}
		} catch (Exception e) {
			e.printStackTrace();

			return "Teacher doen't exist";
		}

	}

	public List<TeacherDto> getTeacherByStdId(int id) {
		List<Teacher> list = dao.getTeacherByStdId(id);
		List<TeacherDto> l1 = new ArrayList<>();
		list.forEach((e) -> {
			l1.add(TeacherSetter.setDto(e));

		});

		return l1;
	}

}
