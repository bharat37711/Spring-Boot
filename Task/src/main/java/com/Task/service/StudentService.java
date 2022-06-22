package com.Task.service;

import java.util.List;

import com.Task.dto.StudentCityDto;
import com.Task.entity.Student;


public interface StudentService {


	public List<Student> getStudentList();
	
	public Student getStundentById(int id);
	
	void saveStudent(StudentCityDto s);

	public List<StudentCityDto> getListOfStudentWithCity();
	
	public StudentCityDto getSingleStudentwithCity(int id);
	

}
