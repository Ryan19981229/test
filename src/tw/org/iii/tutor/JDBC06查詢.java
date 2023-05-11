package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.plaf.nimbus.State;

public class JDBC06查詢 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii",prop);
		String sql = "Select * FROM food";
		Statement stmt = conn.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		
		while(result.next()) {
			//Moves the cursor forward one row from its current position.
		System.out.println(result.getString("name"));
		}
		result.close();
		System.out.println("ok");
		}catch(Exception e) {
			System.out.println(e);
			
		}

	}

}
