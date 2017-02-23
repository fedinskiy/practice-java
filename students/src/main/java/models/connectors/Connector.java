package models.connectors;

import java.sql.Connection;
import org.postgresql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by fedinskiy on 23.02.17.
 */
public class Connector {
	private static final String USER = "test";//Логин пользователя
	private static final String PASSWORD = "test";//Пароль пользователя
	private static final String URL = "jdbc:postgresql://localhost:5432/mfdb";//URL адрес
	private static final String DRIVER = "org.postgresql.Driver";//Имя драйвера
	private static Properties p=new Properties();
	
	public static Connection getConnection() throws SQLException {
		Driver.getVersion();
		p.put("user",USER);
		p.put("password",PASSWORD);
		p.put("characterEncoding","UTF-8");
		return DriverManager.getConnection(URL,p);
	}
	
}
