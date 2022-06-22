package com.demoBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.demoBoot.entity.StudentSubject;

public interface StudentSubjectDao  extends JpaRepository<StudentSubject,Integer>{
	
	@Modifying
	@Query("delete from StudentSubject  where studentId =:id")
	public void deleteRowBySudentId(int id);
	@Modifying
	@Query("delete from StudentSubject  where subjectId =:id")
	public void deleteRowBySubjectId(int id);


}
