package com.helpezee.springdatajpa.springdatajpawithcrudRepositiry.repository;

import org.springframework.data.repository.CrudRepository;

import com.helpezee.springdatajpa.springdatajpawithcrudRepositiry.model.Dept;

public interface DeptRepository extends CrudRepository<Dept, Integer> {

	Iterable<Dept> findByLoc(String loc);

	Iterable<Dept> findByDname(String dname);

	Iterable<Dept> findByDnameAndLoc(String dname, String loc);

}
