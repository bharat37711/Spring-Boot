package com.Task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.Task.dto.StudentCityDto;
import com.Task.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {

	
	private StudentService studentService;
	
	public StudentController(StudentService service) {
		// TODO Auto-generated constructor stub
		
		this.studentService=service;
	}

	@PostMapping("/saveStudent")
	public ResponseEntity<?> saveStudent(@RequestBody StudentCityDto dto) {

		studentService.saveStudent(dto);
		return new ResponseEntity<>(dto, HttpStatus.CREATED);

	}

	@PostMapping("/getStudent/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Integer id) {

		return new ResponseEntity<>(studentService.getStundentById(id), HttpStatus.CREATED);

	}

	@GetMapping("/getAllStudnet")
	public ResponseEntity<?> getAllStudent() {

		return new ResponseEntity<>(studentService.getStudentList(), HttpStatus.CREATED);

	}

	@PostMapping("/getAllStudnetwithCity")
	public ResponseEntity<?> getAllStudentwithCity() {

		return new ResponseEntity<>(studentService.getListOfStudentWithCity(), HttpStatus.CREATED);

	}

	@PostMapping("/getSingleStudent/{id}")
	public ResponseEntity<?> getSingleStudentwithCity(@PathVariable Integer id) {

		return new ResponseEntity<>(studentService.getSingleStudentwithCity(id), HttpStatus.CREATED);

	}

}
