package ru.fedinskiy.sqlconnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by fedinskiy on 16.02.17.
 */
public class StudentOperator extends TableOperator {
	public StudentOperator() {
		super("students","name","id", new String[]{"id","name","birthdate","sex","group_id"});
	}
}
