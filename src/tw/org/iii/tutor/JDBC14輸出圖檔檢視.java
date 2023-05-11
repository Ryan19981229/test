package tw.org.iii.tutor;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC14輸出圖檔檢視 {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://localhost/iii";
	private static final String SQL_QUERT = 
		"SELECT * FROM member WHERE id = ?";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER); 
		prop.put("password", PASSWORD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERT);
			pstmt.setInt(1, 1);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				InputStream in = rs.getBinaryStream("icon"); //非文字黨要用二進制
				FileOutputStream fout = new FileOutputStream("dir1/ball1.png");
				byte[] buf = new byte[128*1024];
				int len = in.read(buf);
				fout.write(buf, 0, len);
				fout.flush();
				fout.close();
				System.out.println("OK");
			}else {
				System.out.println("data ERROR");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}