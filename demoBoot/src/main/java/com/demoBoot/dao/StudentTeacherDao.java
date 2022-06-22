package com.demoBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.demoBoot.entity.StudentTeacher;

public interface StudentTeacherDao extends JpaRepository<StudentTeacher, Integer> {
	@Modifying
	@Query("delete from StudentTeacher  where studentId =:id")
	public void deleteRowBySudentId(int id);
	
	@Modifying
	@Query("delete from StudentTeacher  where teacherId =:id")
	public void deleteRowByTeacherId(int id);


}
