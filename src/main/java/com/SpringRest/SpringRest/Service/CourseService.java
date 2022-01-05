package com.SpringRest.SpringRest.Service;

import java.util.List;

import com.SpringRest.SpringRest.Entity.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void delCourse(long courseId);

}
