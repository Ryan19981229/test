package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.org.iii.myclasses.BCrypt;
import tw.org.iii.myclasses.Member;

public class JDBC10帳號密碼登入 {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://localhost/iii";
	private static final String SQL_LOGIN = 
		"SELECT * FROM member WHERE account = ?";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Account : ");
		String account = scanner.next();
		
		System.out.print("Password : ");
		String passwd = scanner.next();
		
		Properties prop = new Properties();
		prop.put("user", USER); prop.put("password", PASSWORD);

		try (Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_LOGIN)){
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String hsPasswd = rs.getString("passwd");
				
				if (BCrypt.checkpw(passwd, hsPasswd)) {
					//進行比較
					//用于检查给定的明码和暗码是否匹配。
					Member member = new Member();
					member.setAccount(rs.getString("account"));
					member.setPasswd(passwd);
					member.setId(rs.getInt("id"));
					member.setEmail(rs.getString("email"));
					welcome(member);
				}else {
					// get out here
					System.out.println("Login fsilure");
				}
			}else {
				System.out.println("Login fsilure");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static void welcome(Member member) {
		System.out.println( "Welcome, " + 
				member.getAccount() + ":" + member.getEmail());
	}

}