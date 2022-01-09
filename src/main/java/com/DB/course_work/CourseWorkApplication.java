package com.DB.course_work;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/DB/course_work/DAO/mapper")
public class CourseWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseWorkApplication.class, args);
	}

}
