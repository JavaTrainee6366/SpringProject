package com.SpringRest.SpringRest.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringRest.SpringRest.Entity.Course;
import com.SpringRest.SpringRest.Service.CourseService;

// @Controller   it can be for normal web app
@RestController      // It is for rest API
public class MyController {
	
	// Dependency Injections : it will automatically create object for interface
	@Autowired
	private CourseService obj ;
	//localhost:8080/home
	@GetMapping("/home")
	public String home() {
		
		return "Welcome HOme";
		
	}

	// Get the courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		return this.obj.getCourses();
			
		
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId){
		
		return this.obj.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/addCourse")
	public Course addCourse(@RequestBody Course course)
	{
		
		
		return this.obj.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course)
	{
		
		
		return this.obj.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> delCourse(@PathVariable String courseId){
		
		try {
			this.obj.delCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
