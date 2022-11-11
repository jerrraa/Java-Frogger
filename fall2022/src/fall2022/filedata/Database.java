package fall2022.filedata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
//used this function to generate my database
	/*
	public void CreateDatabase() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:score.db";
			conn = DriverManager.getConnection(dbURL);
			if (conn!=null) {
				System.out.println("Connected to database");
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				String sql = "CREATE TABLE IF NOT EXISTS USERSCORE " +
						 "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + " NAME TEXT NOT NULL, " + " SCORE INT NOT NULL)";
				//Execute the statement
				stmt.executeUpdate(sql);
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	private void DisplayRecords(ResultSet rs) throws SQLException {
		 while ( rs.next() ) 
		 {
			 int id = rs.getInt("id");
			 String name = rs.getString("name");
			 int score = rs.getInt("score");
			 System.out.println("ID = " + id);
			 System.out.println("name = " + name);
			 System.out.println("score = " + score);
		 }
		
	}

	public void UploadDatabase(String name, int score) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:score.db";
			conn = DriverManager.getConnection(dbURL);
			if (conn!=null) {
				System.out.println("Connected to database");
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				String sql = "INSERT INTO USERSCORE (NAME, SCORE) VALUES "
				+ "('"+name+"',"+score+")" ;
				//Execute the statement
				stmt.executeUpdate(sql);
				conn.commit();
				//
				sql = "SELECT * FROM userscore";
				ResultSet rs = stmt.executeQuery(sql);
				DisplayRecords(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
