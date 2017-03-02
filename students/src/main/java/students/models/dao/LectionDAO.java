package students.models.dao;

import org.springframework.stereotype.Component;
import students.exception.LectionDAOException;
import students.models.connectors.Connector;
import students.models.pojo.Lection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fedinskiy on 24.02.17.
 */
@Component
public class LectionDAO extends BasicDAO {
	private static final String SQL_DELETE_LECTION = "DELETE FROM main.lections WHERE id in";
	private static final String SQL_UPDATE_LECTION = "UPDATE main.lections SET name=?, date=?, group_id=? WHERE id=?";
	private static final String SQL_ALL_LECTIONS = "SELECT * FROM main.lections";
	private static final String SQL_LECTIONS_BY_ID = "SELECT * FROM main.lections WHERE id in";
	
	private static Logger logger = LogManager.getLogger(LectionDAO.class);
	
	public List<Lection> getAllLections() throws LectionDAOException {
		List<Lection> studentList = new ArrayList<>();
		try (Connection connection = Connector.getConnection()) {
			Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(SQL_ALL_LECTIONS);
			while (resultSet.next()) {
				studentList.add(getLectionFromResult(resultSet));
			}
		} catch (SQLException e) {
			logger.error(e);
			throw new LectionDAOException();
		}
		return studentList;
		
	}
	
	public void deleteLectionsById(String[] chosen) throws LectionDAOException {
		try {
			deleteById(chosen, SQL_DELETE_LECTION);
		} catch (SQLException e) {
			logger.error(e);
			throw new LectionDAOException();
		}
	}
	
	public Lection getLectionById(String id) throws LectionDAOException {
		try {
			final ResultSet byId = getById(new String[]{id}, SQL_LECTIONS_BY_ID);
			if(byId.next()){
				return getLectionFromResult(byId);
			}
			return null;
		} catch (SQLException e) {
			logger.error(e);
			throw new LectionDAOException();
		}
	}
	
	public List<Lection> getNearedLections(){
		return null;
	}
	
	public boolean saveLection(Lection lection) throws LectionDAOException {
		try (Connection connection = Connector.getConnection()) {
			final PreparedStatement preparedStatement = putLectionToUpdateStatement(connection, lection);
			return preparedStatement.execute();
			
		} catch (SQLException e) {
			logger.error(e);
			throw new LectionDAOException();
		}
	}
	private Lection getLectionFromResult(ResultSet resultSet) throws SQLException {
		Lection lection = new Lection();
		lection.setId(resultSet.getInt("id"));
		lection.setName(resultSet.getString("name"));
		lection.setDate(resultSet.getDate("date"));
		lection.setGroupId(resultSet.getInt("group_id"));
		return lection;
	}
	private PreparedStatement putLectionToUpdateStatement(Connection connection, Lection lection) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_LECTION);
		preparedStatement.setString(1,lection.getName());
		preparedStatement.setDate(2, Date.valueOf(lection.getDate()));
		preparedStatement.setLong(3,lection.getGroupId());
		preparedStatement.setLong(4,lection.getId());
		return preparedStatement;
	}
}
