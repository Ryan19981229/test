package tw.org.iii.tutor;

import tw.org.iii.myclasses.Bike;

public class Brad25字串equal用法 {

	public static void main(String[] args) {
		String str1 = "Brad";
		String str2 = "Brad";
		String str3 = new String("Brad");
		System.out.println(str1.equals(str2)); //這是比內容 不是比記憶體
		System.out.println(str1.equals(str3)); //注意看!!正常說會是false
		System.out.println("------");
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		System.out.println(b1.equals(b2)); //記憶體不一樣
		Bike b3 = b2 ;
		System.out.println(b2.equals(b3)); //記憶體一樣
	}

}
