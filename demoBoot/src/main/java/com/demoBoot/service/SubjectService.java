package com.demoBoot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoBoot.dao.StudentSubjectDao;
import com.demoBoot.dao.SubjectBookDao;
import com.demoBoot.dao.SubjectDao;
import com.demoBoot.dao.SubjectTeacherDao;
import com.demoBoot.dto.SubjectDto;
import com.demoBoot.entity.Subject;
import com.demoBoot.entity.SubjectTeacher;
import com.demoBoot.setter.SubjectSetter;

@Service
@Transactional
public class SubjectService {

	@Autowired
	private SubjectDao dao;

	@Autowired
	private StudentSubjectDao studentSubjectDao;

	@Autowired
	private SubjectTeacherDao subjectTeacherDao;

	@Autowired
	private SubjectBookDao subjectBookDao;
	public boolean addSubject(SubjectDto dto) {

		Subject subject = SubjectSetter.setSubject(dto);

		Subject t = dao.save(subject);
		if (t.equals(null)) {
			return false;
		}

		else {
			return true;
		}
	}

	public List<SubjectDto> getSubject() {

		List<Subject> list = dao.findAll();

		List<SubjectDto> l1 = new ArrayList<>();
		list.forEach((e) -> {
			l1.add(SubjectSetter.setDto(e));
		});

		return l1;

	}

	public String deleteSubject(int id) {

		studentSubjectDao.deleteRowBySubjectId(id);
		subjectTeacherDao.deleteRowBySubjectId(id);
		subjectBookDao.deleteRowBySubjectId(id);
		dao.deleteById(id);
		return "Subject deleted";

	}

	public String updateSubject(int id, SubjectDto dto) {
		try {
			Subject t = dao.getById(id);

			if (t.equals(null)) {
				return "subject doen't exist";

			} else {
				dao.save(SubjectSetter.setSubject(id, dto));
				return "subject updated ";
			}
		} catch (Exception e) {
			e.printStackTrace();

			return "Subject doen't exist";
		}

	}

	public List<SubjectDto> getSubjectByStudentId(int id) {

		List<Subject> list = dao.getSubjectsByStudentId(id);
		List<SubjectDto> l1 = new ArrayList<>();

		list.forEach((e) -> {
			l1.add(SubjectSetter.setDto(e));
		});
		return l1;
	}

	public List<SubjectDto> getSubjectByTeacherId(int id) {

		List<Subject> list = dao.getSubjectsByteacherId(id);

		List<SubjectDto> l1 = new ArrayList<>();

		list.forEach((e) -> {
			l1.add(SubjectSetter.setDto(e));
		});
		return l1;
	}

}
