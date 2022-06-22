package com.demoBoot.setter;

import com.demoBoot.dto.TeacherDto;
import com.demoBoot.entity.Teacher;

public class TeacherSetter {

	public static Teacher setTecher(TeacherDto dto) {
		
		Teacher obj= new Teacher();
		obj.setName(dto.getName());
		obj.setAge(dto.getAge());
		return obj;
	}

	public static TeacherDto setDto(Teacher e) {
		
		TeacherDto dto =new TeacherDto();
		dto.setName(e.getName());
		dto.setAge(e.getAge());
		
		return dto;
	}
public static Teacher setTecher(int id ,TeacherDto dto) {
		
		Teacher obj= new Teacher();
		obj.setId(id);
		obj.setName(dto.getName());
		obj.setAge(dto.getAge());
		return obj;
	}

}
