package models.pojo;

import java.security.PrivateKey;

/**
 * Created by fedinskiy on 23.02.17.
 */
public class User {
	private int idUser;
	private String login;
	private String password;
	private String role;
	
	public User() {
	}
	
	public User(int iduser, String login, String password, String role) {
		this.idUser = iduser;
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	public int getIdUser() {
		return idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
}
