

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>

spring-boot-starter-data-rest will provide all the retrival functions inbuilt.
we have functionality like sorting,pagination and limit records apart from regular CRUD Operations




http://localhost:8080/emps (get All employees)

http://localhost:8080/emps/1 (gets specific employee information

http://localhost:8080/emps?sort=name,desc (sorting and ordering by name)

http://localhost:8080/emps?page=1 (default to 20 records)

http://localhost:8080/emps?size=1 (no of records)

http://localhost:8080/emps?page=2&size=10 (Each page contains 10 records and displays page 2 items)

http://localhost:8080/emps?page=2&size=10&sort=salary,desc (Each page contains 10 records and displays page 2 items in specific sorting order)