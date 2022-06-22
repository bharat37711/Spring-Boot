package com.Task.entity;


import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.auditing.CurrentDateTimeProvider;

import com.Task.ENUM.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "students")
public class Student  {

	private int id;
	private int cityId;
	private String course;
	private Date createOnDate;
	private String dob;
	private String fatherName;
	private Gender gender;
	private Boolean isActive;
	private String name;

	 
	public Student() {
		super();
	}

	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}
	

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Column(name = "city_id")
	public int getCityId() {
		return cityId;
	}

	public String getCourse() {
		return course;
	}

	@Column(name = "create_on_date")
	public Date getCreateOnDate() {
		return createOnDate;
	}

	@Column(name = "dob")
	public String getDob() {
		return dob;
	}

	@Column(name = "father_name")
	public String getFatherName() {
		return fatherName;
	}

	@Column(name = "is_active")
	public Boolean getIsActive() {
		return isActive;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public void setCreateOnDate(Date localDate) {
		this.createOnDate = localDate;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", cityId=" + cityId + ", course=" + course + ", createOnDate=" + createOnDate
				+ ", dob=" + dob + ", fatherName=" + fatherName + ", isActive=" + isActive + ", name=" + name + "]";
	}

}
