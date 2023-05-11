package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.json.JSONStringer;
import org.json.JSONWriter;

public class JDBC12製作jsonArray {
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://localhost/brad";

	public static void main(String[] args) {
		String sql = 
			"select e.FirstName, e.LastName, sum(od.UnitPrice * od.Quantity) sum "
			+ "from orders o "
			+ "join employees e on (o.EmployeeID = e.EmployeeID) "
			+ "join orderdetails od on (o.OrderID = od.OrderID) "
			+ "GROUP by e.FirstName, e.LastName "
			+ "ORDER by sum desc";
		
		Properties prop = new Properties();
		prop.put("user", USER); prop.put("password", PASSWORD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			JSONStringer js = new JSONStringer();
			JSONWriter jw = js.array();
			int rank = 1;
			while (rs.next()) {
				String firstName = rs.getString("Firstname");
				String lastName = rs.getString("Lastname");
				double sum = rs.getDouble("sum");
				
				jw.object();//JSONWriter 提供的方法之一 此代码将生成以下 JSON 字符串：
				jw.key("rank").value(rank++);
				jw.key("firstname").value(firstName);
				jw.key("lasttname").value(lastName);
				jw.key("sum").value(sum);
				jw.endObject();
				//JSONStringer 是一個類別，可以用來建立一個 JSON 格式的字串。
				//JSONWriter 則是 JSONStringer 的一個內部類別，可以用來建立一個 JSON Array 或 Object。
				
				
				//System.out.println(rs.getString("Firstname") + ":" + rs.getString("sum"));
				
			}
			jw.endArray();
			//可以使用 jw.array() 開始一個新的 Array，然後透過多次呼叫 jw.value() 來添加 Array 中的元素，
			//最後使用 jw.endArray() 來標記該 Array 的結束。
			System.out.println(jw.toString());
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		

		
		
	}

}



			
