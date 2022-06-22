package com.demoBoot.dto;



public class StudentDto {
	
private String name;


private String lastName;


public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public StudentDto() {
	super();
}

public StudentDto(String name) {
	
	this.name = name;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Override
public String toString() {
	return "StudentDto [name=" + name + ", lastName=" + lastName + "]";
}



	

}
