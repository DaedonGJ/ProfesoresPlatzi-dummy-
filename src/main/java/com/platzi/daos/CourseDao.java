package com.platzi.daos;

import java.util.List;

import com.platzi.modelo.Course;
import com.platzi.modelo.Teacher;

public interface CourseDao {

	void saveCourse(Course course);
	void deleteCourseById(Long idcourse);
	void updateCourse(Course course);
	List<Course> findAllCourses();
	Course findById(Long idcourse);
	Course findByName(String name);
	List<Course> findByIdTeacher(Long idTeacher);
	
}
