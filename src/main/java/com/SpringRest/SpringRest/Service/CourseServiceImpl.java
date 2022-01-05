package com.SpringRest.SpringRest.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringRest.SpringRest.Entity.Course;
import com.SpringRest.SpringRest.dao.CourseDao;

@Service
public class CourseServiceImpl implements CourseService{
	
	//List<Course> list ;
	@Autowired
	private CourseDao coursedao;
	
	public CourseServiceImpl() {
		// TODO Auto-generated constructor stub
		// DAO layer : will be used for database connectivity
		
		/*
		 * list = new ArrayList<Course>();
		 * 
		 * list.add(new Course(202, "Android", "Android Course")); list.add(new
		 * Course(203, "Iphone", "Iphone Course")); list.add(new Course(204, "Python",
		 * "Python Course")); list.add(new Course(205, "Java", "Java Course"));
		 * list.add(new Course(206, "SQA", "SQA Course"));
		 */
	}

	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		
		//return list;  //without database
		
		return coursedao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		/*
		 * Course c = null;
		 * 
		 * for(Course c1 : list ) { if(c1.getId() == courseId) { c = c1; break; } }
		 * return c;
		 */
		return coursedao.getOne(courseId);
	}

	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		
		//list.add(course);
		return coursedao.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		/*
		 * list.forEach(e -> { if(e.getId()==course.getId()) {
		 * e.setTitle(course.getTitle()); e.setDescription(course.getDescription()); }
		 * }); //list.add(course); return course;
		 */	
		return coursedao.save(course);
	
	}

	/*
	 * public Course delCourse(long courseId) { // TODO Auto-generated method stub
	 * Course c = null;
	 * 
	 * for(Course c1 : list ) { if(c1.getId() == courseId) { c = c1; break; } }
	 * return c; }
	 */

	public void delCourse(long parseLong) {
		//list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
	Course entity =	coursedao.getById(parseLong);
	coursedao.delete(entity);
		
	}
	
	

}
