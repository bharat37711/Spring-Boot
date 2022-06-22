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

import com.demoBoot.dto.BookDto;
import com.demoBoot.dto.TeacherDto;
import com.demoBoot.service.BookService;
import com.demoBoot.service.TeacherService;

@RestController
@RequestMapping("/v2")
public class BookController {
	@Autowired
	private BookService service;

	@PostMapping("/saveBook")
	public ResponseEntity<?> saveBook(@RequestBody BookDto dto){
		
		return new ResponseEntity<>(service.addBook(dto) ,HttpStatus.CREATED);
	}

	@GetMapping("/getBook")
	public ResponseEntity<?> getBook(){
		
		System.out.println("hello");
		
		return new ResponseEntity<>(service.getBook() ,HttpStatus.CREATED);
	}
	
	@PostMapping("/deleteBook/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable int id){
		
		return new ResponseEntity<>(service.deleteBook( id) ,HttpStatus.CREATED);
	}
	
	@PostMapping("/updateBook/{id}")
	public ResponseEntity<?> updateBook(@PathVariable int id ,@RequestBody BookDto dto){
		
		return new ResponseEntity<>(service.updateBook(id , dto) ,HttpStatus.CREATED);
	}
	
	@GetMapping("/getBookBySubjectId/{id}")
public ResponseEntity<?> getBookBySubjectId(@PathVariable int id){
		
	
	return new ResponseEntity<>(service.getBooksBySubjectId(id), HttpStatus.ACCEPTED);
	
}

}
