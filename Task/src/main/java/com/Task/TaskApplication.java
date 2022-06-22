package com.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Task.ENUM.Gender;
import com.Task.dao.CityDao;
import com.Task.entity.City;
import com.Task.entity.Student;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
 
	}

}
