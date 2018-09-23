package com.platzi.daos;


import java.util.Iterator;
import java.util.List;

import com.platzi.modelo.Teacher;
import com.platzi.modelo.TeacherSocialMedia;


public class TeacherDaoImpl extends AbstractSession implements TeacherDao {

	@Override
	public void saveTeacher(Teacher teacher) {
		getSession().persist(teacher);
		
	}

	@Override
	public void deleteTeacherById(Long idTeacher) {
	Teacher teacher = findById(idTeacher);
	
	if (teacher !=null) {
		Iterator<TeacherSocialMedia> i =teacher.getTeacherSocialMedias().iterator();
		while(i.hasNext()) {
			TeacherSocialMedia teacherSocialMedia=i.next();
			i.remove();
			getSession().delete(teacherSocialMedia);
		}
		teacher.getTeacherSocialMedias().clear();
		getSession().delete(teacher);
	}
		
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		getSession().update(teacher);
		
	}

	@Override
	public List<Teacher> findAllTeachers() {
	
		return getSession().createQuery("from Teacher").list();
	}

	@Override
	public Teacher findById(Long idTeacher) {
		// TODO Auto-generated method stub
		return getSession().get(Teacher.class, idTeacher);
	}

	@Override
	public Teacher findByName(String name) {
		// TODO Auto-generated method stub
		return (Teacher)getSession().createQuery( "from Teacher where name = :name").setParameter("name", name).uniqueResult();
	}
	


	}
