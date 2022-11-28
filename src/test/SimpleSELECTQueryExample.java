package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleSELECTQueryExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driverClassName = "com.mysql.cj.jdbc.Driver";//In case of MySQL
		//String driverClassName = "oracle.jdbc.OracleDriver"//In case of Oracle
		String URL = "jdbc:mysql://192.168.100.80:3306/group029?useSSL=false";//In case of MySQL
		//String URL = "jdbc:oracle:thin:@localhost:1521:xe;//In case of Oracle 
		String UID = "group029";
		String PWD = "group029";
		
		Connection dbConnection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//Loading the Driver
			Class.forName(driverClassName);
			System.out.println("Driver loaded");
			
			//Establishing Connection
			dbConnection = DriverManager.getConnection(URL, UID, PWD);
			System.out.println("Connected to DB");
			
			//Obtaining the Statement
			stmt = dbConnection.createStatement();
			
			//Executing SQL +Query and obtaining ResultSet
			String sqlQuery = 
					"select id, namefirst from student";
			rs = stmt.executeQuery(sqlQuery);
			
			//Performing Navigation
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
//				int duration = rs.getInt(3);
//				String id = rs.getString(4);
				System.out.println(name + ", " + id);
			}		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
				dbConnection.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}






