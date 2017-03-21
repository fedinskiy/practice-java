package ru.fedinskiy.students.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by fedinskiy on 21.03.17.
 */
@Entity
@Table(name = "students", schema = "main", catalog = "mfdb")
public class StudentsEntity {
	private Integer id;
	private String name;
	private Date birthdate;
	private String sex;
	
	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Basic
	@Column(name = "name", nullable = true, length = -1)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Basic
//	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate", nullable = true)
	public Date getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	@Basic
	@Column(name = "sex", nullable = true, length = -1)
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		StudentsEntity that = (StudentsEntity) o;
		
		if (id != that.id) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (birthdate != null ? !birthdate.equals(that.birthdate) : that.birthdate != null) return false;
		if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
		result = 31 * result + (sex != null ? sex.hashCode() : 0);
		return result;
	}
}
