package com.helpezee.springdatajpa.springdatajpawithcrudRepositiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.helpezee.springdatajpa.springdatajpawithcrudRepositiry.model.Dept;
import com.helpezee.springdatajpa.springdatajpawithcrudRepositiry.repository.DeptRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.helpezee.springdatajpa.springdatajpawithcrudRepositiry.repository")
@EntityScan(basePackages="com.helpezee.springdatajpa.springdatajpawithcrudRepositiry.model")
public class SpringdatajpawithcrudRepositiryApplication {
	
	@Autowired
	private DeptRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpawithcrudRepositiryApplication.class, args);
	}
	
	@Bean("saveData")
	public void saveDatatoDB() {
		
		for(int i=0;i<50;i++) {
			Dept d = new Dept();
			d.setDeptno(i);
			d.setDname("DName" );
			if ((i%20) == 0)
				d.setLoc("Hyd");
			else
				d.setLoc("Blr");
			repo.save(d);
		}
		
		Dept d = new Dept();
		d.setDeptno(10);
		d.setDname("TrainingDept");
		d.setLoc("Pune" );
		repo.save(d);
		
			
		}
	
	@Bean
	@DependsOn("saveData")
	public void searchQueries() {
		
		repo.findAll().forEach(System.out::println);
		
		repo.deleteById(30);
	
		repo.findAll().forEach( System.out::println);
		
	    repo.findByLoc("Blr").forEach( System.out::println);
			
			
	    repo.findByDname("DName40" ).forEach( System.out::println);
			
			
	    repo.findByDnameAndLoc("DName","Hyd").forEach( System.out::println);
		
	}
	}

