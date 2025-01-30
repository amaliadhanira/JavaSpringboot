package com.in28minutes.spring.learn_spring_framework.enterprise.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyWebController {
	private BusinessService businessService;
	
	public long returnValueFromBusinessService() {
		return businessService.calculateSum();
	}
}

@Component
class BusinessService{
	
	private DataService dataService;
	
	@Autowired
	public BusinessService(DataService dataService) {
		super();
		System.out.println("Setter Injection");
		this.dataService = dataService;
	}
	
	public long calculateSum() {
		List<Integer> data = dataService.getData();
		return data.stream().reduce(Integer::sum).get();
	}	
}

@Component
class DataService{
	public List<Integer> getData() {
		return Arrays.asList(10,20,30,40);
	}
}
