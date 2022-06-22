package com.demoBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_subject")
public class StudentSubject {
	@Id
	@Column(name = "id")
private int id;
	@Column(name = "student_id")
private int studentId;
	@Column(name = "subject_id")
private int subjectId;
}
