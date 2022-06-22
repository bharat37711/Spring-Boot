package com.demoBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demoBoot.dto.StudentDto;
import com.demoBoot.service.StudentService;

@RestController
@RequestMapping("/v2")
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/saveStudent")
	public ResponseEntity<?> saveStudent(@RequestBody StudentDto dto) {

		service.saveStudent(dto);

		return new ResponseEntity<>(dto + ": saved", HttpStatus.CREATED);
	}

	@GetMapping("/getAllStudents")
	public ResponseEntity<?> getAllStudents() {

		return new ResponseEntity<>(service.getAllStudents(), HttpStatus.ACCEPTED);
	}

	@PostMapping("/deleteStudent/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable int id) {

		return new ResponseEntity<>(service.deleteStudent(id), HttpStatus.CREATED);

	}

	@PostMapping("/updateStudent/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody StudentDto dto) {

		return new ResponseEntity<>(service.updateStudent(id, dto), HttpStatus.CREATED);

	}

	@GetMapping("/getStdByTeacher/{id}")
	public ResponseEntity<?> getStdByTeacher(@PathVariable int id) {

		return new ResponseEntity<>(service.getStudentsByTeacherId(id), HttpStatus.CREATED);

	}

}