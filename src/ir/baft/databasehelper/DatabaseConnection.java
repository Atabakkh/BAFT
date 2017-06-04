package ir.baft.databasehelper;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {

    Connection conn = null;
    String url;
    String driver;
    String userName;
    String password;

    public Connection mySqlConnection() {

    	//mysql -h127.0.0.1 -uroot -patibavaj
        url = "jdbc:mysql://127.0.0.1:3306/baft";
        driver = "com.mysql.jdbc.Driver";
        userName = "root";
        password = "atibavaj";

        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, userName, password);
//            System.out.println("Connected.");
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}