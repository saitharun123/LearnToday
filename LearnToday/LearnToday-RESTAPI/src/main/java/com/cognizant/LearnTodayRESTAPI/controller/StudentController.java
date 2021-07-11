package com.cognizant.LearnTodayRESTAPI.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.LearnTodayRESTAPI.model.Student;
import com.cognizant.LearnTodayRESTAPI.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TrainerController.class);
	
	@GetMapping("/student")
	public ResponseEntity<Object> getAllCourses(){
		LOGGER.info("The Current function is used to get the course details");
		return new ResponseEntity<>(studentService.getAllCourses(), HttpStatus.OK);
	}

	@PostMapping("/student")
	public ResponseEntity<Object> postStudent(@RequestBody Student s){
		LOGGER.info("The current function will post the student details in the table");
		if(studentService.postStudent(s))
			return new ResponseEntity<Object>( HttpStatus.CREATED);
		return new ResponseEntity<Object>( HttpStatus.BAD_REQUEST);
		
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Object> deleteStudentEnrollment(@PathVariable int id) {
		LOGGER.info("The current function will delete the student given the student id");	
		if(studentService.deleteStudent(id))
				return new ResponseEntity<Object>( HttpStatus.OK);
		return new ResponseEntity<Object>("No enrollment information found", HttpStatus.NOT_FOUND);
	}
}
