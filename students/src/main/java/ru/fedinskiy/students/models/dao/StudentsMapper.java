package ru.fedinskiy.students.models.dao;

import ru.fedinskiy.students.models.pojo.Student;

/**
 * Created by fedinskiy on 17.03.17.
 */
public interface StudentsMapper {
	Student getStudentById(Integer id);
}
