package tw.org.iii.tutor;

import tw.org.iii.myclasses.Bike;

public class Brad24字串無法更改與Bike {

	public static void main(String[] args) {
		String s1 = "Brad";
		String s2 = s1.concat("Chao");
		String s3 = s1.replace('a', 'A'); //s1字串內容無法改變，改變得的是s3的值
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		System.out.println("------");
		
		int a = 10,b = 3;
		System.out.println(a == b);
		System.out.println("------");
		String str1 = "Brad";
		String str2 = "Brad";//記憶體位子一樣
		System.out.println(str1 == str2);
		System.out.println("------");
		String str3 = new String("Brad");
		String str4 = new String("Brad");//記憶體位子不一樣
		System.out.println(str3 == str4);
		System.out.println(str1 == str3);
		System.out.println(str3);
		System.out.println("------");
		
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		System.out.println(b1 == b2);
		System.out.println(b1); //印出物件是印出記憶體位子
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		System.out.println(b1);
		
		
		
		
		
	}

}
