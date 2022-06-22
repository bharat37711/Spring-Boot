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

import com.demoBoot.dto.SubjectDto;
import com.demoBoot.dto.TeacherDto;
import com.demoBoot.service.SubjectService;
import com.demoBoot.service.TeacherService;

@RestController
@RequestMapping("/v2")
public class SubjectController {
	@Autowired
	SubjectService service;

	@PostMapping("/saveSubject")
	public ResponseEntity<?> saveSubject(@RequestBody SubjectDto dto){
		
		return new ResponseEntity<>(service.addSubject(dto) ,HttpStatus.CREATED);
	}

	@GetMapping("/getsubject")
	public ResponseEntity<?> getSubject(){
		
		return new ResponseEntity<>(service.getSubject() ,HttpStatus.CREATED);
	}
	
	@PostMapping("/deleteSubject/{id}")
	public ResponseEntity<?> deleteSubject(@PathVariable int id){
		
		return new ResponseEntity<>(service.deleteSubject( id) ,HttpStatus.CREATED);
	}
	
	@PostMapping("/updateSubject/{id}")
	public ResponseEntity<?> updateSubject(@PathVariable int id ,@RequestBody SubjectDto dto){
		
		return new ResponseEntity<>(service.updateSubject(id , dto) ,HttpStatus.CREATED);
	}
	
	@GetMapping("/getsubjectByStudentId/{id}")
	public ResponseEntity<?> getSubjectByStudentId(@PathVariable int id){
		
		return new ResponseEntity<>(service.getSubjectByStudentId(id) ,HttpStatus.CREATED);
	}
	
	@GetMapping("/getsubjectByTeacherId/{id}")
	public ResponseEntity<?> getSubjectByTeacherId(@PathVariable int id){
	
		
		return new ResponseEntity<>(service.getSubjectByTeacherId(id) ,HttpStatus.CREATED);
	}
}
