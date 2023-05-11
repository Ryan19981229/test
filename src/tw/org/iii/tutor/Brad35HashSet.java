package tw.org.iii.tutor;

import java.util.HashSet;

import tw.org.iii.myclasses.Bike;

public class Brad35HashSet {

	public static void main(String[] args) {
		HashSet set = new HashSet(); //Set: 1.不會重複 2.沒有順序性 EX.帳號
		set.add("Brad");
		set.add(new Bike());
		set.add(123);  //123=>auto-boxing
		//HashSet 可以存放基本型別和其對應的物件型別。在這裡 123 是一個基本型別的整數，
		//會自動轉換成 Integer 物件，然後被加入到 HashSet 中。這個過程稱為 auto-boxing。
		set.add("Brad");
		set.add(123);
		System.out.println(set.size());
		System.out.println(set.toString());//呼叫bike toString()
	}

}
