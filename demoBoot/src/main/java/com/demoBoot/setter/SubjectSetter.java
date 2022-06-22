package com.demoBoot.setter;

import com.demoBoot.dto.SubjectDto;
import com.demoBoot.dto.TeacherDto;
import com.demoBoot.entity.Subject;
import com.demoBoot.entity.Teacher;

public class SubjectSetter {

	public static Subject setSubject(SubjectDto dto) {
		
		Subject obj= new Subject();
		obj.setName(dto.getName());
		return obj;
	}

	public static SubjectDto setDto(Subject e) {
		
		SubjectDto dto =new SubjectDto();
		dto.setName(e.getName());
		
		return dto;
	}
public static Subject setSubject(int id ,SubjectDto dto) {
		
	Subject obj= new Subject();
		obj.setId(id);
		obj.setName(dto.getName());
		return obj;
	}

}
