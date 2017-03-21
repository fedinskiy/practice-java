package ru.fedinskiy.students.interfaces;

import ru.fedinskiy.students.entities.StudentsEntity;

import java.util.List;

/**
 * Created by fedinskiy on 21.03.17.
 */
public interface StudentService {
	List<StudentsEntity> findAll();
	List<StudentsEntity> findByname(String name);
}
