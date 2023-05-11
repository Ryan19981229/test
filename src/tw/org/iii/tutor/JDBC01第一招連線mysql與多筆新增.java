//與MySQL連線: 
//JDBC代表Java Database Connectivity，是Java平台上一個用於執行關聯式數據庫操作的API。
//下載 MySQL 的 JDBC 驅動程式，這是一個用於與 Java 連接的程式庫。
//可以從 MySQL 官方網站下載最新版本的驅動程式。
package tw.org.iii.tutor;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC01第一招連線mysql與多筆新增 {// 第一招比第二招彈性還要大

	public static void main(String[] args) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			// 載入驅動程式;在lang裡面，找出類別(class);裡面的去google找
//			// Class Class<T> 裡面
//			System.out.println("ok");
//
//		} catch (Exception e) {
//			System.out.println(e);
//		} // ****以上新版java可以不用寫出來，但是在JAVA web不行****

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iii?user=root&password=root");
			// jdbc要跟mysql講話，mysql要跟localhostru講話;要帶參數要先放"?"localhost要跟iii講話
			//sql裡面DriverManager;getConnection() 是 DriverManager 的靜態方法，用來取得指定資料庫的連線。
			Statement stmt = conn.createStatement();
			//在Java.connection.createStatement裡面
			//創建一個 Statement 對象，用於將 SQL 語句發送到數據庫。
			// 通過連接的 createStatement() 方法獲取 Statement 對象的實例，用於執行 SQL 查詢或更新。
			// 從連線身上取得敘述句的物件實體
			String sql = "INSERT INTO cust (cname,tel,birthday) VALUES" + 
			"('aa','123','1999-01-02'),"+"('aa','1233','1998-01-02'),"+"('aa','12343','1995-01-02')";
			stmt.execute(sql);//(方法1:多筆新增;還傳布林值)
			//int count = stmt.executeUpdate(sql);  //(方法2:回傳變更行數)在sql.statment裡面
			//傳入的參數 sql 是一個代表 SQL 語句的字串，可以是 INSERT、UPDATE 或 DELETE 語句，
			//也可以是一個 DDL 語句（如 CREATE、ALTER 或 DROP）。
//			如果該 SQL 語句成功執行，則返回受影響的行數。
			//System.out.println(count);
			System.out.println("OK2");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
