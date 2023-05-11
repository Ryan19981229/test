package tw.org.iii.tutor;

import java.util.HashSet;
import java.util.Iterator;

public class Brad36迭代器Iterator {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>(); //類別
		set.add("III");
		set.add("Brad");
		set.add("Tony");

		Iterator<String> it = set.iterator();// 迭代器(捲線器)(方法)
		while (it.hasNext()) {//下面還有的話繼續執行
			System.out.println(it.next()); //每次拿東西出來
		}
		System.out.println("-----");
		for (String v : set) { //for迴圈 of(elements)
			System.out.println(v);
		}
	}  

}
