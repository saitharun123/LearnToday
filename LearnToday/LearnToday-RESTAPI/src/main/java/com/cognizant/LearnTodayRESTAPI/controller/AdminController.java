package com.cognizant.LearnTodayRESTAPI.controller;

import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.LearnTodayRESTAPI.model.Course;
import com.cognizant.LearnTodayRESTAPI.service.CourseService;

@RestController
@RequestMapping("/api")
public class AdminController {
	@Autowired
	CourseService courseService;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	@GetMapping("/admin")
	public ResponseEntity<Object> getAllCourses(){
		LOGGER.info("The current function is to get all courses");
		return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
	}
	@GetMapping("/admin/{courseId}")
	public ResponseEntity<Object> getCourseById(@PathVariable("courseId") int courseId){
		LOGGER.info("The current function is to get course by id");
		Course course = courseService.getCourseById(courseId);
	//	if(course!=null)
		//	return new ResponseEntity<>(course, HttpStatus.OK);
		
		Optional<Course> checkNull=Optional.ofNullable(course);
		if(checkNull.isPresent())
		{
			return new ResponseEntity<>(course, HttpStatus.OK);
		}
		return new ResponseEntity<>("Searched Data Not Found", HttpStatus.NOT_FOUND);
	}
	
}