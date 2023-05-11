package tw.org.iii.tutor;

import java.util.ArrayList;
//ArrayList 是 Java 提供的一個動態陣列類別，可以在運行時動態調整大小，
//並提供了許多方便的方法來操作集合中的元素，如新增、刪除、修改和查詢等。
import java.util.Collections;

public class PokerV4 {

	public static void main(String[] args) {
		ArrayList<Integer> poker = new ArrayList<>(); //泛型
		for (int i=0; i<10; i++) poker.add(i);
		for (int v: poker) {
			System.out.println(v);
		}
		System.out.println("-----");
		Collections.shuffle(poker);
		for (Integer v: poker) {
			System.out.println(v);
		}
	}

}