package tw.org.iii.tutor;

import java.util.LinkedList;

public class Brad38LinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>(); 
		//與ArrayList不同是，ArrayList變動性不高(效能差)
		list.add(1); list.add(3); list.add(10);
		System.out.println(list);
		list.add(3);
		System.out.println(list);
		System.out.println(list.get(2));
		System.out.println("------");
		
		list.add(2,7); //7放在第二位子
		System.out.println(list);
		
	}

}
