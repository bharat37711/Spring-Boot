package com.demoBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demoBoot.entity.Book;


public interface BookDao extends JpaRepository<Book, Integer> {
	
	@Query("select b from Book b where id in (select x.bookId from SubjectBook x where subjectId=:id)")
	public List<Book> getBookBySubjectId(int id);

}