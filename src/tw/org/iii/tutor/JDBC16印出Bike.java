package tw.org.iii.tutor;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.org.iii.myclasses.Bike;

public class JDBC16印出Bike {
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
				InputStream in = rs.getBinaryStream("bike");
//InputStream in = rs.getBinaryStream("bike") 從資料庫讀取欄位名為bike的二進位制資料，並將其轉換為一個InputStream物件。
				ObjectInputStream oin = new ObjectInputStream(in);
				Object obj = oin.readObject();
				//從ObjectInputStream讀取一個物件，並將其存儲為一個Object物件。
				if (obj instanceof Bike) {
					Bike b2 = (Bike)obj;
					System.out.println(b2);
				}else {
					System.out.println("I am not bike");
				}
				
				System.out.println("OK");
			}else {
				System.out.println("data ERROR");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}