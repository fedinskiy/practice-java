package ru.fedinskiy.students.implementations;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fedinskiy.students.entities.StudentsEntity;
import ru.fedinskiy.students.interfaces.StudentService;
import ru.fedinskiy.students.repository.StudentsRepository;

import java.util.List;

/**
 * Created by fedinskiy on 21.03.17.
 */

//@Service("jpaStudentService")
@Repository
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentsRepository repository;
	
	@Override
	public List<StudentsEntity> findAll() {
		return Lists.newArrayList(repository.findAll());
	}
	
	@Override
	public List<StudentsEntity> findByname(String name) {
		return repository.findByname(name);
	}

	@Override
	public void deleteStudents(List<Integer> chosen) {
		final Iterable<StudentsEntity> chosenStudents = repository.findAll(chosen);
		repository.delete(chosenStudents);
	}
}
