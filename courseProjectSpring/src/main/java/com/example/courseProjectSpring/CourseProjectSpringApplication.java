package com.example.courseProjectSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseProjectSpringApplication {

	public static void main(String[] args) {
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		SpringApplication.run(CourseProjectSpringApplication.class, args);

//		context.close();
		/*ConfigurableApplicationContext context = SpringApplication.run(CourseProjectSpringApplication.class, args);
		PersonService service = context.getBean(PersonService.class);
		service.menu();*/
	}

}
