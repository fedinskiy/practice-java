package ru.fedinskiy.sqlconnection;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * Created by fedinskiy on 16.02.17.
 */
public abstract class TableOperator {
	protected final String table;
	protected final String[] columnList;
	protected final String nameColumn;
	protected final String idColumn;
	private final String SCHEMA = "main";
	private final String DELIMETER = ".";
	
	protected TableOperator() {
		table = "";
		columnList = null;
		nameColumn = "";
		idColumn = "";
	}
	
	protected TableOperator(String table, String nameColumn, String idColumn, String[] columnList) {
		this.table = table;
		this.nameColumn = nameColumn;
		this.columnList = columnList;
		this.idColumn = idColumn;
	}
	
	protected String getColumnList() {
		String columnText = "";
		
		for (String column : columnList) {
			if (!column.equals(this.idColumn)) {
				columnText = columnText.concat(column + ",");
			}
		}
		columnText = columnText.substring(0, columnText.length() - 1);
		return columnText;
	}
	
	protected String getEmptyColumnValues() {
		String columnText = "";
		
		for (int i = 0; i < (columnList.length - 1); i++) {
			columnText = columnText.concat("?,");
		}
		columnText = columnText.substring(0, columnText.length() - 1);
		return columnText;
	}
	
	protected String getSetColumnValues() {
		String columnText = "";
		for (String column : columnList) {
			if (!column.equals(this.idColumn)) {
				columnText = columnText.concat(column + "=?,");
			}
		}
		columnText = columnText.substring(0, columnText.length() - 1);
		return columnText;
	}
	
	protected String getTableName() {
		return SCHEMA + DELIMETER + table;
	}
	
	private Connection connection() throws SQLException {
		return ConnectionManager.getConnection();
	}
	
	public ResultSet getAllInfo() throws SQLException {
		Statement query = connection().createStatement();
		return query.executeQuery("SELECT * FROM " + getTableName());
	}
	
	public ResultSet getInfoById(int id) throws SQLException {
		Statement query = connection().createStatement();
		final String sqlQ = "SELECT * FROM " + getTableName() + " WHERE id=" + id;
		return query.executeQuery(sqlQ);
	}
	
	public ResultSet getInfoByName(String name) throws SQLException {
		Statement query = connection().createStatement();
		final String queryText = "SELECT * FROM " + getTableName() + " WHERE " + nameColumn + " ='" + name + "'";
		return query.executeQuery(queryText);
	}
	
	public PreparedStatement getInsertStatement() throws SQLException {
		String sqlQ = "INSERT INTO  " + getTableName() + " (" + getColumnList() + ") VALUES (" +
				getEmptyColumnValues() + ")";
		PreparedStatement ps = connection().prepareStatement(sqlQ);
		return ps;
	}
	public void changeStringField(int id,String fieldName, String value) throws SQLException {
		final PreparedStatement updateStatement;
		updateStatement = getUpdateStatement(idColumn + "=" + id, fieldName + "='" + value+"'");
		updateStatement.execute();
	}
	
	protected PreparedStatement getUpdateStatement(String condition, String ToSet) throws SQLException {
		String sqlQ = "UPDATE " + getTableName() + " SET " + ToSet + " WHERE " + condition;
		PreparedStatement ps = connection().prepareStatement(sqlQ);
		return ps;
	}
	
	protected PreparedStatement getUpdateStatement(String condition) throws SQLException {
		return getUpdateStatement(condition,getSetColumnValues());
	}
	
	public PreparedStatement getUpdateById(int id) throws SQLException {
		return getUpdateStatement(idColumn+"="+id);
	}
	
	private PreparedStatement getDeleteStatement(String condition) throws SQLException {
		String sqlQ = "DELETE FROM " + getTableName() + " WHERE " + condition;
		PreparedStatement ps = connection().prepareStatement(sqlQ);
		return ps;
	}
	
	public boolean deleteByName(String name) throws SQLException {
		final PreparedStatement deleteStatement = getDeleteStatement(this.nameColumn + "='" + name + "'");
		return deleteStatement.execute();
	}
	
	public boolean deleteById(int id) throws SQLException {
		final PreparedStatement deleteStatement = getDeleteStatement("id=" + id + "");
		return deleteStatement.execute();
	}
}
