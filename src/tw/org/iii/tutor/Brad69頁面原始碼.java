package tw.org.iii.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class Brad69頁面原始碼 {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.ispan.com.tw");
			HttpURLConnection conn = 
				(HttpURLConnection)url.openConnection();//強制轉型是為了使用這個connect方法
			conn.connect();
			
			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ( (line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
			
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
