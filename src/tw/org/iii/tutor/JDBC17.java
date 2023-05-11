package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC17 {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://localhost/iii";
	private static final String SQL_QUERT = "SELECT * FROM cust";
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER); prop.put("password", PASSWORD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(
					SQL_QUERT,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("cname");
				System.out.printf("%s:%s\n", id, name);
			}
			System.out.println("---");
			
			if (rs.first()) {
				System.out.println("move first OK");
				String id = rs.getString("id");
				String name = rs.getString("cname");
				System.out.printf("%s:%s\n", id, name);
				
				rs.absolute(4);
				String id4 = rs.getString("id");
				String name4 = rs.getString("cname");
				System.out.printf("%s:%s\n", id4, name4);
			}else {
				System.out.println("OK");
			}
			System.out.println("---");
			
			rs.updateString("cname", "new aa");
			rs.updateString("tel", "321");
			rs.updateRow();
			
			System.out.println("---");
			rs.absolute(2);
			String id = rs.getString("id");
			String name = rs.getString("cname");
			System.out.printf("%s:%s\n", id, name);

			//rs.deleteRow();//刪掉後會自動指定上一個
			
			String id7 = rs.getString("id");
			String name7 = rs.getString("cname");
			System.out.printf("%s:%s\n", id7, name7);
			//刪掉後會自動指定上一個
			System.out.println("---");
			
			rs.moveToInsertRow();
			rs.updateString("cname", "new row");
			rs.updateString("tel", "1234567");
			rs.updateString("birthday", "1999-01-02");
			rs.insertRow();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}


