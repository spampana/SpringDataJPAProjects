package com.helpezee.springdatajpa.springdatajpawithjpaRepositiry;

import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.helpezee.springdatajpa.springdatajpawithjpaRepository.model.Emp;
import com.helpezee.springdatajpa.springdatajpawithjpaRepository.repo.EmpRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.helpezee.springdatajpa.springdatajpawithjpaRepository.repo")
@EntityScan(basePackages="com.helpezee.springdatajpa.springdatajpawithjpaRepository.model")
public class SpringdatajpawithjpaRepositiryApplication {
	
	@Autowired
	EmpRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpawithjpaRepositiryApplication.class, args);
	}
	
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
	
	
	@Bean
	@DependsOn("saveData")
	public String queries1(){
		System.out.println("1. in Project1 ");
		repo.search("Project1","Amar").forEach(System.out::println);
		return " ss";
	}
		
	@Bean
	@DependsOn("saveData")
	public String queries(){
		System.out.println("1. in Project1 ");
		repo.findByProject("Project1").forEach(System.out::println);
		
		System.out.println("2. project1 and name as 'Simran'");
		repo.findByProjectAndName("Project1","Simran").forEach(System.out::println);
		
		System.out.println(" 3. name starting with S ");
		repo.findByNameStartingWith("S").forEach(System.out::println);
		
		System.out.println("4. Name containing lo");
		repo.findByNameContaining("lo").forEach(System.out::println);
		
		System.out.println("5. Name ending with ni");
		repo.findByNameEndingWith("ni").forEach(System.out::println);
		
		System.out.println(" 6. Salary between 100 and 250");
		repo.findBySalaryBetween(100, 250).forEach(System.out::println);
		
		System.out.println(" 7. Name Simran or Project project1");
		repo.findByProjectOrName("Project1", "Simran").forEach(System.out::println);
		
		return "success";
	}
	
	@Bean
	@DependsOn("saveData")
	public String page(){
		
		Pageable pageable = PageRequest.of(0, 10);
		Scanner scanner = new Scanner(System.in);
		char c = 'a';
		while(c != 'Q')
		{
			Page<Emp> page = repo.findAll(pageable);
			page.get().forEach(System.out::println);
			System.out.println("Please enter Next/Prev/Quit");
			c = scanner.next().charAt(0);
			if (c =='N')
				pageable = pageable.next();
			if (c =='P')
				pageable = pageable.previousOrFirst();
		}
		return "success";
	}

	@Bean
	@DependsOn("saveData")
	public String sort1() {
		Sort s1 = new Sort(Direction.DESC, "name");
		Sort s2 = Sort.by("salary");
		repo.findAll(s1.and(s2)).forEach(System.out::println);

		return "success";
	}



}
