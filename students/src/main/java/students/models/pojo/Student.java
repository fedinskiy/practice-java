package students.models.pojo;

import java.sql.Date;
import java.time.LocalDate;

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
	
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate.toLocalDate();
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
}
