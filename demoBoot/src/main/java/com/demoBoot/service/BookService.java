package com.demoBoot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoBoot.dao.BookDao;
import com.demoBoot.dao.SubjectBookDao;
import com.demoBoot.dao.TeacherDao;
import com.demoBoot.dto.BookDto;
import com.demoBoot.dto.TeacherDto;
import com.demoBoot.entity.Book;
import com.demoBoot.entity.SubjectBook;
import com.demoBoot.entity.Teacher;
import com.demoBoot.setter.BookSetter;
import com.demoBoot.setter.TeacherSetter;

@Service
@Transactional
public class BookService {
	@Autowired
	private BookDao dao;
	@Autowired
	private SubjectBookDao subjectBookDao;
	
	public  boolean addBook(BookDto dto) {
		
		Book book= BookSetter.setBook(dto);
		
		Book t=	dao.save(book);
		if(t.equals(null)){
			return false;
		}
		
		else{
			return true;
		}
	}

	public List<BookDto> getBook() {
		
		List<Book>  list=dao.findAll();
		
		List<BookDto> l1=new ArrayList<>();
		list.forEach((e)->{
			l1.add(BookSetter.setDto(e));
		});
		
		return l1;
		
	}

	public String deleteBook(int id) {
		
		subjectBookDao.deleteRowByBookId(id);
		dao.deleteById(id);
		return "Book deleted";
	

	}

	public String updateBook(int id, BookDto dto) {
		try {
			Book t= dao.getById(id);
			
			if(t.equals(null)) {
				return "Book doen't exist";
				
			}
			else {
				dao.save(BookSetter.setBook(id ,dto));
				return "Book updated " ; 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			
			return "Book doen't exist";
		}
		
				
		

	}
	public List<BookDto> getBooksBySubjectId(int id) {
		
		List<Book> list=dao.getBookBySubjectId(id);

		List<BookDto> l1=new ArrayList<>();
		
		list.forEach((e)->{
			l1.add(BookSetter.setDto(e));
		});
		
		return l1;
	}
	
	
}
