package com.Task.ServiceImp;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.stereotype.Service;

import com.Task.dao.CityDao;
import com.Task.dao.StudentDao;
import com.Task.dto.StudentCityDto;
import com.Task.entity.City;
import com.Task.entity.Student;
import com.Task.service.StudentService;


@Service
public class StuddentServiceImp implements StudentService {

	private StudentDao studentDao;

	private CityDao cityDao;

	public StuddentServiceImp(StudentDao studentDao, CityDao cityDao) {
		super();
		this.studentDao = studentDao;
		this.cityDao = cityDao;
	}

	@Override
	public void saveStudent(StudentCityDto s) {
		// TODO Auto-generated method stub

		Student st = new Student();
        java.util.Date d=new  java.util.Date();
		st.setId(s.getStudentId());
		// st.setCityId(s.getCityId());
		st.setCourse(s.getCourse());
		st.setDob(s.getDob());
		st.setFatherName(s.getFatherName());
		st.setGender(s.getGender());
		st.setName(s.getName());
		st.setIsActive(true);
		//st.setCreateOnDate(new java.sql.Date(date.getTime()));
		System.out.println("iys saveStudent");

		City city = new City();
		city.setName(s.getCityName());
		city.setIsActive(true);
		
		List<City> list = cityDao.getUserByName(s.getCityName());
		
       if(list.size()==0) {
    	 City c=  cityDao.save(city);
    	st.setCityId(c.getId());
       }
	
       else {
    	   st.setCityId(list.get(0).getId());
	}
   
       System.out.println(studentDao.save(st).getClass().getName());
		Student s1= studentDao.save(st);
		System.out.println(s1.getId());
	}

	@Override
	public Student getStundentById(int id) {
    Student student =studentDao.getById(id);
	
	
		return student;
	}

	@Override
	public List<Student> getStudentList() {
		List<Student> list= studentDao.findAll();
				
		return list;
	}

	@Override
	public List<StudentCityDto> getListOfStudentWithCity() {
	  List<Student> students= studentDao.findAll();
	  List<City> cities=cityDao.findAll();
	  StudentCityDto dto=new StudentCityDto();
	  List<StudentCityDto> dtos =new ArrayList<>();
	  students.forEach((e)->{
		 dto.setCourse(e.getCourse());
		 dto.setDob(e.getDob());
		 dto.setFatherName(e.getFatherName());
		 dto.setGender(e.getGender());
		 dto.setName(e.getName());
		 dto.setStudentId(e.getId());
	
		 cities.forEach((f)->{
		 if(f.getId()==e.getCityId()) {
			 dto.setCityName(f.getName());
		 }
	 });
		  
		 dtos.add(dto);
	  });
		return dtos;
	}

	@Override
	public StudentCityDto getSingleStudentwithCity(int id) {
		Student e=studentDao.getById(id);
		City city=cityDao.getById(e.getCityId());
		 StudentCityDto dto=new StudentCityDto();
		 dto.setCourse(e.getCourse());
		 dto.setDob(e.getDob());
		 dto.setFatherName(e.getFatherName());
		 dto.setGender(e.getGender());
		 dto.setName(e.getName());
		 dto.setStudentId(e.getId());
		 dto.setCityName(city.getName());
		return dto;
	}

	

}
