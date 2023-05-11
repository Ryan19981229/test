package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC02第二招 {//第二招
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", "root", "root");

			Statement stmt = conn.createStatement();
			//String sql = "INSERT INTO cust (cname,tel,birthday) VALUES ('aa','123','1999-01-02')";
			//String sql ="DELETE FROM cust WHERE id<=5";  **刪除**
			String sql ="UPDATE cust SET cname='brad',tel = '321' WHERE id>=40";  //**修改**
			
			int count = stmt.executeUpdate(sql); //執行更新
			System.out.println(count);

			System.out.println("OK2");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
