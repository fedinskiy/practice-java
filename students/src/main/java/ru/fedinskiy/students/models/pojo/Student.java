package ru.fedinskiy.students.models.pojo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by fedinskiy on 23.02.17.
 */
public class Student {
	private long id;
	private String name;
	private LocalDate birthdate;
	private String sex;
	
	public Student() {

	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(java.sql.Date birthdate) {
		
		this.birthdate = birthdate.toLocalDate();
	}
	
	public void setBirthdate(Date birthdate) {
		
		this.birthdate = birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", birthdate=" + birthdate +
				", sex='" + sex + '\'' +
				'}';
	}
}
