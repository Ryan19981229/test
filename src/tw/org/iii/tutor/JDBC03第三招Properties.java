package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class JDBC03第三招Properties {// 第三招彈性更大更好(老師喜歡)
	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			// 在util裡面; Properties是一種資料結構，有鍵與值(類似map)
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", prop);

			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM cust WHERE id IN (42, 45)";

			int count = stmt.executeUpdate(sql);
			System.out.println(count);

			System.out.println("OK2");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}