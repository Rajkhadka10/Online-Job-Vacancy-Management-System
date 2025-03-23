package com.bway.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springproject.model.Seekers;

public interface SeekersRepository extends JpaRepository<Seekers, Integer>{

Seekers findByUsernameAndPassword(String un, String psw);

Seekers findByUsername(String Username);

Seekers findByPassword(String Password);
}