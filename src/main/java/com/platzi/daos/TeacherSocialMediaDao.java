package com.platzi.daos;

import java.util.List;

import com.platzi.modelo.Teacher;

public interface TeacherSocialMediaDao {
	
	void saveTeacher(Teacher teacher);
	
	void deleteTeacherById(Long idTeacher);
	
	void updateTeacher(Teacher teacher);
	
	List<Teacher> findAllTeachers();
	
	Teacher findById(Long idTeacher);
	
	Teacher findByName(String name);

}
