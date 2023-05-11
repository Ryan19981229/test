package tw.org.iii.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

public class JDBC05json解析第三方 {

	public static void main(String[] args) {
		// network
		try {
			String json = getFoodData();
			parseJSON(json);
			System.out.println("finish");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	static String getFoodData() throws Exception {
		URL url = new URL("https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
		HttpURLConnection conn = 
			(HttpURLConnection)url.openConnection(); //向下轉型，去用CONNECT
		//openConnection()方法來建立一個HTTP連線。這個方法會回傳一個URLConnection物件，
		//但是因為我們要使用HttpURLConnection特有的方法，所以需要把它轉型成HttpURLConnection型態。
		conn.connect();
		
		BufferedReader reader = 
			new BufferedReader(
					//BufferedReader是一個帶有緩存的讀取器，它能夠提高IO效率，尤其是當需要一次性讀取大量數據時，
					//使用BufferedReader可以減少IO操作的次數，從而提升效率。
				new InputStreamReader(conn.getInputStream()));
		//可以使用 getInputStream() 方法來獲取從伺服器返回的數據流
		//InputStreamReader is a bridge from byte streams to character streams: 
		String line; 
		StringBuffer sb = new StringBuffer();
		//LinkedList<String> sb = new LinkedList<>(); 
		//StringBuffer 是一個用來存放和操作字符串的可變物件 
		//它可以有效地修改字符串而不需要新建一個新的字串物件。
		while ( (line = reader.readLine()) != null) {
			sb.append(line);
			
		}
		reader.close();
		
		return sb.toString();
		//最後，透過呼叫 sb.toString() 方法可以獲取完整的字串。
		
	}

	// parse JSON
	static void parseJSON(String json) throws Exception {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/iii", prop);
		
		//1.delete from food 
		//2.ALTER TABLE food AUTO 
		
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("DELETE FROM food");
		stmt.executeUpdate("ALTER TABLE food AUTO_INCREMENT = 1");
		
		
		String sql = "INSERT INTO food (name,address,tel,picurl,latitude,longitude)" + 
				" VALUES (?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql); 
		
		JSONArray root = new JSONArray(json); 
		//在JAVA JSON 第三方API有的
		//先看資料結構，地一層如果是陣列就是陣列
		for (int i=0; i<root.length(); i++) {
			
			JSONObject row = root.getJSONObject(i);
			//取得陣列裡面的物件{}
			pstmt.setString(1, row.getString("Name"));
			pstmt.setString(2, row.getString("Address"));
			pstmt.setString(3, row.getString("Tel"));
			pstmt.setString(4, row.getString("PicURL"));
			try {
				pstmt.setDouble(5, Double.parseDouble(row.getString("Latitude")));
				//用於將字符串轉換為 double 型別的數值。
			}catch(Exception e) {
				pstmt.setDouble(5, 0);
				//度或經度資訊缺失或格式錯誤，則將該欄位的值設定為 0。
			}
			try {
				pstmt.setDouble(6, Double.parseDouble(row.getString("Longitude")));
			}catch(Exception e) {
				pstmt.setDouble(6, 0);
			}
			pstmt.executeUpdate();
		}
	}	
	
}