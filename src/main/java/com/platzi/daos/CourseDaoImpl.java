package com.platzi.daos;

import java.util.List;

import com.platzi.modelo.Course;

public class CourseDaoImpl  extends AbstractSession implements CourseDao  {

	@Override
	public void saveCourse(Course course) {
		getSession().persist(course);

	}

	@Override
	public void deleteCourseById(Long idcourse) {
		 Course course = findById(idcourse);
		 if( course!=null) getSession().delete(course);
	}

	@Override
	public void updateCourse(Course course) {
		getSession().update(course);

	}

	@Override
	public List<Course> findAllCourses() {
		
		return getSession().createQuery("from Course").list();
	}

	@Override
	public Course findById(Long idcourse) {
	
		return (Course)getSession().get(Course.class, idcourse);
	}

	@Override
	public Course findByName(String name) {
		// TODO Auto-generated method stub
		return (Course) getSession().createQuery("from Course where name = :name").setParameter("name", name).uniqueResult();
	}

	@Override
	public List<Course> findByIdTeacher(Long idTeacher) {
		// TODO Auto-generated method stub
		return (List<Course>) getSession().createQuery("from Course c join c.teacher t where t.idTeacher = :idTeacher").setParameter("idTeacher", idTeacher);
	}

}
