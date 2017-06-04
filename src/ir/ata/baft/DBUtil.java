package ir.ata.baft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	static Connection cn = null;
	Properties props = new Properties();

	public Connection getConnect() {
		try {
			// System.out.println("swati srivastava&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&___________________>>>>>>>>>>>>"+props.getProperty("dbuser"));
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/world", "root", "");
		} catch (ClassNotFoundException se) {
			se.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return cn;
	}

}