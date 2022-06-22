package com.demoBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject_book")
public class SubjectBook {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "subject_id")
	private int subjectId;
	@Column(name = "book_id")
	private int bookId;

}
