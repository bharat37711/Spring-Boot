package com.demoBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject_teacher")
public class SubjectTeacher {
@Id
@Column(name = "id")
 private int id;
@Column(name = "subject_id")
 private int subjectId ;
@Column(name = "teacher_id")
 private int teacherId;
 
}



