package com.Task.dto;

import com.Task.ENUM.Gender;

public class StudentCityDto {

	private int studentId;
	private String name;
	private String fatherName;
	private String course;
	private String dob;
	private  Gender gender;
	private String cityName;
	
	
	public StudentCityDto() {
		super();
	}
	public StudentCityDto(int studentId, String name, String fatherName, String course, String dob, Gender gender,
			String cityName) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.fatherName = fatherName;
		this.course = course;
		this.dob = dob;
		this.gender = gender;
		this.cityName = cityName;
	}
	public int getStudentId() {
		return studentId;
	}
	public String getName() {
		return name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public String getCourse() {
		return course;
	}
	public String getDob() {
		return dob;
	}
	public Gender getGender() {
		return gender;
	}
	public String getCityName() {
		return cityName;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "StudentCity [studentId=" + studentId + ", name=" + name + ", fatherName=" + fatherName + ", course="
				+ course + ", dob=" + dob + ", gender=" + gender + ", cityName=" + cityName + "]";
	}
	
	
}
