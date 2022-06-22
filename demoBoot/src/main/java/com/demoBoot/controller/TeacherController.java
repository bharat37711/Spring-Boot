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

import com.demoBoot.dto.TeacherDto;
import com.demoBoot.service.TeacherService;

@RestController
@RequestMapping("/v2")
public class TeacherController {
	@Autowired
	TeacherService service;

	@PostMapping("/saveTeacher")
	public ResponseEntity<?> saveTeacher(@RequestBody TeacherDto dto) {

		return new ResponseEntity<>(service.addTeacher(dto), HttpStatus.CREATED);
	}

	@GetMapping("/getTeachers")
	public ResponseEntity<?> getTeachers() {

		return new ResponseEntity<>(service.getTeachers(), HttpStatus.CREATED);
	}

	@PostMapping("/deleteTeacher/{id}")
	public ResponseEntity<?> deleteTeacher(@PathVariable int id) {

		return new ResponseEntity<>(service.deleteTeacher(id), HttpStatus.CREATED);
	}

	@PostMapping("/updateTeacher/{id}")
	public ResponseEntity<?> updateTeacher(@PathVariable int id, @RequestBody TeacherDto dto) {

		return new ResponseEntity<>(service.updateTeacher(id, dto), HttpStatus.CREATED);
	}

	@GetMapping("/getTeacherByStdId/{id}")
	public ResponseEntity<?> getTeacherByStdId(@PathVariable int id) {

		return new ResponseEntity<>(service.getTeacherByStdId(id), HttpStatus.CREATED);
	}

}
