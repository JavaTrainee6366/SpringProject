package com.SpringRest.SpringRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringRest.SpringRest.Entity.Course;

public interface CourseDao extends JpaRepository<Course, Long> {

}
