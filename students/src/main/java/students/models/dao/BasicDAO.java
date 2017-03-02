package students.models.dao;

import students.models.connectors.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by fedinskiy on 24.02.17.
 */
public abstract class BasicDAO {
	
	protected static void deleteById(String[] ids, String deletionSQL) throws SQLException {
		try (Connection connection = Connector.getConnection()) {
			Statement statement = connection.createStatement();
			String sqlQ= new String(deletionSQL+"(");
			for(String idString:ids){
				int id=Integer.parseInt(idString);
				sqlQ=sqlQ.concat(id+",");
			}
			sqlQ=sqlQ.substring(0,sqlQ.length()-1);
			sqlQ=sqlQ+")";
			
			statement.executeQuery(sqlQ);
		}
	}
	protected static ResultSet getById(String[] ids, String SQLQuery) throws SQLException {
		try (Connection connection = Connector.getConnection()) {
			Statement statement = connection.createStatement();
			String sqlQ= new String(SQLQuery+"(");
			for(String idString:ids){
				int id=Integer.parseInt(idString);
				sqlQ=sqlQ.concat(id+",");
			}
			sqlQ=sqlQ.substring(0,sqlQ.length()-1);
			sqlQ=sqlQ+")";
			
			return statement.executeQuery(sqlQ);
		}
	}
}
