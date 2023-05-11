package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class JDBC13輸入圖檔進去 {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://localhost/iii";
	private static final String SQL_UPDATE_ICON = 
			"UPDATE member SET icon = ? WHERE id = ?";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER); prop.put("password", PASSWORD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE_ICON);
			FileInputStream fin = new FileInputStream("dir1/icons8-足球2-50.png");
			pstmt.setBinaryStream(1, fin); //非文字檔案需要用二進制
			pstmt.setInt(2, 1);
			if (pstmt.executeUpdate() > 0) {
				System.out.println("Update success");
			}else {
				System.out.println("Update failure");
			}
		}catch(Exception e) {
			
			System.out.println(e);
		}

	}

}
