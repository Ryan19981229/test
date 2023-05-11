package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

import tw.org.iii.myclasses.BCrypt;

public class JDBC11更改密碼 {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://localhost/iii";
	private static final String SQL_CHPASSWD = 
		"UPDATE member SET passwd = ? WHERE account = ?";
	private static final int INDEX_PASSWD = 1; 
	private static final int INDEX_ACCOUNT = 2; 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Account : ");
		String account = scanner.next();
		
		System.out.print("Password : ");
		String passwd = scanner.next();
		
		Properties prop = new Properties();
		prop.put("user", USER); prop.put("password", PASSWORD);
		try (Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_CHPASSWD)){
			pstmt.setString(INDEX_ACCOUNT, account);
			pstmt.setString(INDEX_PASSWD, 
				BCrypt.hashpw(passwd, BCrypt.gensalt())); //加密
			if (pstmt.executeUpdate() > 0) {
				//sql 參數為要執行的 SQL 語句，方法會回傳一個整數值，表示更新了多少筆資料。
				System.out.println("ok");
			}else {
				System.out.println("failure");
			}
			
		}catch (Exception e){
			System.out.println(e);
		}
	}

}
