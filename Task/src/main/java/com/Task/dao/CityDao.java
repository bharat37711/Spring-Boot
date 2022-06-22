package com.Task.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Task.entity.City;

@Repository
public interface CityDao extends JpaRepository<City, Integer > {

	@Query(value = "SELECT c FROM City c where name =:name")
	List<City> getUserByName(String name);
	
	

}