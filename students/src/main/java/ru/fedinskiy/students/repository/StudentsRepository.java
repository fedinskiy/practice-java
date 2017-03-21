package ru.fedinskiy.students.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.fedinskiy.students.entities.StudentsEntity;

import java.util.List;

/**
 * Created by fedinskiy on 21.03.17.
 */
@Repository
public interface StudentsRepository extends CrudRepository <StudentsEntity,Integer>{
	List<StudentsEntity> findByname(String name);
}
