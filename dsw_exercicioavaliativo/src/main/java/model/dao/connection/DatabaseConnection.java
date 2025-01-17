package model.dao.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseConnection {
	
	private static final String RESOURCES= "java:/comp/env/jdbc/mysql";

	private DatabaseConnection() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection() throws SQLException {
		
		try {
			InitialContext context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup(RESOURCES);
			return dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
