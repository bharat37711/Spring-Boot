package com.demoBoot.setter;

import com.demoBoot.dto.StudentDto;
import com.demoBoot.entity.Student;

public class StudnetSetter {

	
	public static Student setStudentEntity(StudentDto dto) {
		Student s=new Student();
		s.setName(dto.getName());
		s.setLastName(dto.getLastName());
		return s;
	}
	

	public static StudentDto setStudentDto(Student entity) {
		StudentDto obj=new StudentDto();
		obj.setName(entity.getName());
		obj.setLastName(entity.getLastName());
		return obj;
	}
	

	public static Student setStudentEntity(int id ,StudentDto dto) {
		Student s=new Student();
		s.setId(id);
		s.setName(dto.getName());
		s.setLastName(dto.getLastName());
		return s;
	}
}
