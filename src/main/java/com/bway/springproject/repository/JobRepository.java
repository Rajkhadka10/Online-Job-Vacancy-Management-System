
package com.bway.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springproject.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

}