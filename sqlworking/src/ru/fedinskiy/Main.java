package ru.fedinskiy;

import org.postgresql.Driver;
import ru.fedinskiy.sqlconnection.ConnectionManager;
import ru.fedinskiy.sqlconnection.StudentOperator;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	    System.out.println(Driver.getVersion());
	    StudentOperator operator=new StudentOperator();
	
	     ResultSet rs = operator.getInfoByName("Arnold");
	     rs.next();
	    System.out.println(rs.getString("birthdate"));
	    rs=operator.getInfoById(1);
	    rs.next();
	    System.out.println(rs.getString("name"));
	    rs=operator.getAllInfo();
	    rs.next();
	    
	    System.out.println(rs.getString("name"));
	    operator.changeStringField(4,"name","IRIS");

	    final PreparedStatement insertStatement = operator.getInsertStatement();
	    insertStatement.setString(1, "Nick");
	    java.time.LocalDate ld = LocalDate.of(1978,10,18);
	    insertStatement.setDate(2, Date.valueOf(ld));
	    insertStatement.setString(3, "M");
	    insertStatement.setInt(4, 1);
	    insertStatement.executeUpdate();
	    
	    operator.deleteById(1);

    }
    
    public static void insert(){
	    System.out.println(Driver.getVersion());
	    String url ="jdbc:postgresql://localhost:5432/mfdb?user=test&password=test";
	    try(Connection conn = DriverManager.getConnection(url)) {
		   String sqlQ ="INSERT INTO  main.students ( name, birthdate, sex, group_id) "+
		    "Values (?,?,?,?)";
		   PreparedStatement preparedStatement=conn.prepareStatement(sqlQ);
		 //  preparedStatement.se
	    } catch (SQLException e) {
		    e.printStackTrace();
	    }
    }
    public static void get() throws SQLException {
    	
	   Connection conn = ConnectionManager.getConnection();;
		    Statement query= conn.createStatement();
		    final ResultSet resultSet = query.executeQuery("SELECT * FROM main.students");
		    while (resultSet.next()){
			    final String name = resultSet.getString("name");
			    System.out.println(name);
		    }

    }
}
