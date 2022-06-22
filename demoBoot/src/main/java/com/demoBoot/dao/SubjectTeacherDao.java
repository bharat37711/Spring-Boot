package com.demoBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.demoBoot.entity.SubjectTeacher;

public interface SubjectTeacherDao extends JpaRepository<SubjectTeacher, Integer> {
	
	@Modifying
	@Query("delete from SubjectTeacher where teacherId =:id")
	public void  deleteRowByTeacherId(int id);
	
	
	@Modifying
	@Query("delete from SubjectTeacher where subjectId =:id")
	public void deleteRowBySubjectId(int id);
	
	
	
}