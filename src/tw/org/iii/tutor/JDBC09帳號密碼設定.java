package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.org.iii.myclasses.BCrypt;

public class JDBC09帳號密碼設定 {
	private static Connection conn; // java sql
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://localhost/iii";
	private static final String SQL_CHECK = "SELECT count(*) count FROM member WHERE account = ?";
	// 檢查帳號是否重複
	private static final String SQL_INSERT = "INSERT INTO member (account,passwd,email) VALUES (?,?,?)";

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Account: ");
		String account = scanner.next();

		System.out.println("Password: ");
		String passwd = scanner.next();

		System.out.println("Email: ");
		String email = scanner.next();

		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);

		try {
			conn = DriverManager.getConnection(URL, prop);
			if (checkAccount(account)) {// 檢查帳號是否重複 (true =>沒有重複)
				if (addMember(account, passwd, email)) {// 新增帳號
					System.out.println("Register success");
				} else {
					System.out.println("Register failure");
				}

			} else {
				System.out.println("Account exist");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	static boolean checkAccount(String account) throws Exception {
		boolean ret;
		
		PreparedStatement pstmt = conn.prepareStatement(SQL_CHECK);
		pstmt.setString(1, account);
		ResultSet rs = pstmt.executeQuery();
		rs.next();//移動到第一筆查詢結果的位置，讓我們能夠取得這筆資料。
		ret = rs.getInt("count") == 0;  //如果沒找到就是0 (TRUE)
		rs.close();
		rs = null; // 在java虛擬器(JVM)回收，grabage clearance
		//意味著釋放掉了這個物件所佔用的資源。
		//這樣做是為了幫助 Java 虛擬機垃圾回收機制及時釋放不再使用的資源，減少內存佔用，提高系統效能。

		return ret;
	}

	static boolean addMember(String account, String passwd, String email) throws Exception {
		boolean isOK;
		PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
		pstmt.setString(1, account);
		pstmt.setString(2, BCrypt.hashpw(passwd, BCrypt.gensalt()));
		pstmt.setString(3, email);
		isOK = pstmt.executeUpdate() != 0;
		//則返回一個整數值，表示受到影響的行數。

		return isOK;
	}

}
