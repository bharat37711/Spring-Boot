package com.demoBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demoBoot.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

	@Query("select s from Student s where id in (select x.studentId from StudentTeacher x where teacherId=:id)")
	public List<Student> getStudentsByTeacherId(int id);

}
