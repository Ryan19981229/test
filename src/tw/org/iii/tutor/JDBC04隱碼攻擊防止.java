package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class JDBC04隱碼攻擊防止 {
	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/iii", prop);

			String sql = "INSERT INTO cust (cname,tel,birthday) VALUES (?,?,?)";
			//
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//用於在 Java 中定義 SQL 查詢或更新的參數化（Parameterized）查詢。
			//預先準備的敘述句;connect的方法是prepareStatement，資料型態是(interface)PreparedStatement
			pstmt.setString(1, "Brad");
			pstmt.setString(2, "345");
			pstmt.setString(3, "1998-03-04");
			pstmt.executeUpdate();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}
}