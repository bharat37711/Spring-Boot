package com.demoBoot.dto;

public class TeacherDto {

	private String name;

	private int age;
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TeacherDto [name=" + name + ", age=" + age + "]";
	}


}
