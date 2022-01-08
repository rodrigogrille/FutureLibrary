package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conection {
	Connection con = null;
	public Conection() {
	     String url = "jdbc:mysql://localhost/futurelibrary";
	     try {
	         Class.forName("com.mysql.jdbc.Driver");
	         con = (Connection) DriverManager.getConnection(url, "root", "");
	     } catch (SQLException ex) {
	         System.out.println("Cannot connect to db");
	     } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	     }
	}
	public Connection getConnection() {
		return con;
	}
     
     
     
}
