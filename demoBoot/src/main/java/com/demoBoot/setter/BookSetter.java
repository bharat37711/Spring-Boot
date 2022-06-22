package com.demoBoot.setter;

import com.demoBoot.dto.BookDto;
import com.demoBoot.dto.TeacherDto;
import com.demoBoot.entity.Book;
import com.demoBoot.entity.Teacher;

public class BookSetter {
	public static Book setBook(BookDto dto) {

		Book obj = new Book();
		obj.setName(dto.getName());
		obj.setAuthor(dto.getAuthor());
		return obj;
	}

	public static BookDto setDto(Book e) {

		BookDto dto = new BookDto();
		dto.setName(e.getName());
		dto.setAuthor(e.getAuthor());

		return dto;
	}

	public static Book setBook(int id, BookDto dto) {

		Book obj = new Book();
		obj.setId(id);
		obj.setName(dto.getName());
		obj.setAuthor(dto.getAuthor());
		return obj;
	}
}
