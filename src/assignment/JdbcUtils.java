package assignment;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {
	public static Connection obtainConnection() throws Exception{
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		Class.forName(driverClassName);
		
		String URL = "jdbc:mysql://192.168.100.80:3306/group029_campus?useSSL=false";
		String UID = "group029";
		String PWD = "group029";
		
		Connection dbConnection = DriverManager.getConnection(URL,UID,PWD);
		return dbConnection;
		
	}
}
