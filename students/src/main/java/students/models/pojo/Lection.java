package students.models.pojo;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by fedinskiy on 24.02.17.
 */
public class Lection {
	private String name;
	private long id;
	private LocalDate date;
	private long groupId;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setDate(Date date) {
		this.date = date.toLocalDate();
	}
	public long getGroupId() {
		return groupId;
	}
	
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
}
