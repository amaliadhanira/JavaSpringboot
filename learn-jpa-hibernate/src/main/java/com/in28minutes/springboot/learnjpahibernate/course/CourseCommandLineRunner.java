package com.in28minutes.springboot.learnjpahibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpahibernate.course.springdatajpa.CourseSpringDataJpaRepository;

public class CourseCommandLineRunner implements CommandLineRunner{
	@Autowired
	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Learn AWS", "in28minutes"));
		repository.save(new Course(2, "Learn Azure", "in28minutes"));
		repository.save(new Course(3, "Learn DevOps", "in28minutes"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("in28minutes"));
		System.out.println(repository.findByAuthor(""));
		
		System.out.println(repository.findByName("Learn DevOps"));
		System.out.println(repository.findByName(""));
	}
}
