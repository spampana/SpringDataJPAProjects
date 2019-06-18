package com.helpezee.springdatajpa.springdatajpawithrestrepositories;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.helpezee.springdatajpa.springdatajpawithrestrepositories.model.Emp;
import com.helpezee.springdatajpa.springdatajpawithrestrepositories.repo.EmpRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.helpezee.springdatajpa.springdatajpawithrestrepositories.repo")
@EntityScan(basePackages="com.helpezee.springdatajpa.springdatajpawithrestrepositories.model")
public class SpringdatajpawithrestrepositoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpawithrestrepositoriesApplication.class, args);
	}
	
	@Autowired
	EmpRepository repo;

	
	@Bean("saveData")
	public String insert() {
		String[] names = new String[] { "Simran", "Saloni", "Alone", "Ashwini", "Amar" };
		String[] projects = new String[] { "Project1", "Project2", "Project3" };

		for (int i = 1; i < 50; i += 1) {
			Emp e = new Emp();
			e.setName(names[i % names.length]);
			e.setProject(projects[i % projects.length]);
			e.setSalary((int) (Math.random() * 100) * 10);
			e.setBdate(new Date());
			e.setCom(i * 10);
			repo.save(e);
		}

		return "success";
	}
	
}
