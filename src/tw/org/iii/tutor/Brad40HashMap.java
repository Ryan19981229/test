package tw.org.iii.tutor;

import java.util.HashMap;
import java.util.Set;

public class Brad40HashMap {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>(); 
		//HashMap 中存儲的鍵值對是沒有順序的
		//LinkedHashMap 則是保持了插入時的順序
		map.put("name","Brad");
		map.put("gender",true);
		map.put("age",18);
		System.out.println(map.get("name"));
		System.out.println(map);
		System.out.println("--------");
		
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(map.get(key));
		}
	}
}
