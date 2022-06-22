package com.demoBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demoBoot.entity.Student;
import com.demoBoot.entity.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Integer> {

	@Query("select t from Teacher t where id in (select x.teacherId from StudentTeacher x where x.studentId =:id)")
	public List<Teacher> getTeacherByStdId(int id);

}
