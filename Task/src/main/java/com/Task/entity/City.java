package com.Task.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name ="id")
 private int id;
 @Column(name = "name")
 private String name;
 @Column(name = "is_Active")
 private Boolean isActive;

public City() {
	super();
}
public City(int id, String name, Boolean isActive) {
	super();
	this.id = id;
	this.name = name;
	this.isActive = isActive;
}
public int getId() {
	return id;
}
public String getName() {
	return name;
}
public Boolean getIsActive() {
	return isActive;
}
public void setId(int id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
}
@Override
public String toString() {
	return "City [id=" + id + ", name=" + name + ", isActive=" + isActive + "]";
}
 
 
 
}
