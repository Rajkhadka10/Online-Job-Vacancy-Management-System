package com.bway.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springproject.model.Company;



public interface CompanyRepository extends JpaRepository<Company, Integer>{

	Company findByEmailAndPassword(String el ,String psw);
	
 Company findByEmail(String email);
 
 Company findByPassword(String Password);
}
