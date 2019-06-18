package com.helpezee.springdatajpa.springdatajpawithjpaRepository.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.helpezee.springdatajpa.springdatajpawithjpaRepository.model.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {
	
	@Query(value="select e from Emp e where e.project = ?1 and e.name  = ?2")
	public List<Emp> search(String project, String name);
	
	//1. in Project1
	public List<Emp> findByProject(String project);
	
	//2. project1 and name as 'Simran'
	public List<Emp> findByProjectAndName(String project, String name);
	
	//3. name starting with S
	public List<Emp> findByNameStartingWith(String name);
		
	//4. Name containing lo
	public List<Emp> findByNameContaining(String name);
	
	//5. Name ending with 
	public List<Emp> findByNameEndingWith(String name);
	
	//6. Salary between 100 and 250
	public List<Emp> findBySalaryBetween(double min, double max);
	
	//7. Name Simran or Project project
	public List<Emp> findByProjectOrName(String project, String name);

}
