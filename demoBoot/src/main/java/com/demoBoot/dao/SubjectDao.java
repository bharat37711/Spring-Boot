package com.demoBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.demoBoot.entity.Subject;

public interface SubjectDao extends JpaRepository<Subject, Integer>{
	
	
	
	@Query("select s from Subject s where id in (select x.subjectId from StudentSubject x where studentId=:id)")
	public List<Subject> getSubjectsByStudentId(int id);

	@Query("select s from Subject s where id in (select x.subjectId from SubjectTeacher x where teacherId =:id)")
	public List<Subject> getSubjectsByteacherId(int id);

	
}
