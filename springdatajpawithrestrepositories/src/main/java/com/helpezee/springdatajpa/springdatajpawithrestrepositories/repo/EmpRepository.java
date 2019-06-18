package com.helpezee.springdatajpa.springdatajpawithrestrepositories.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpezee.springdatajpa.springdatajpawithrestrepositories.model.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {
	
	
}
