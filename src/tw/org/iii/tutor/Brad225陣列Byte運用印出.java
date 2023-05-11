package tw.org.iii.tutor;

public class Brad225陣列Byte運用印出 {

	public static void main(String[] args) {
		String s1 = "Brad";//字串是物件;只要雙引號一出現就是物件
		System.out.println(s1);
		System.out.println("Brad".charAt(0));//在字串裡面可以用"."符號，可以用字串的物件
		//第二次指定物件"Brad"指的是第一次創出來的"Brad"
		String s2 = new String(); //沒直接設定要初始化
		s2 = "b";
		byte[] b2;
		b2=new byte[]{97, 98};
		byte[] b1 = {97, 98, 99, 100};//陣列初始化直接用大括號寫;直接丟數字近來不用初始化
		//Byte每個元素不能超出-128~127，不然會數值溢位
		String s3 = new String(b1);//陣列會變成字串
		System.out.println(b1);//陣列輸出是記憶體
		System.out.println(s3);	//陣列轉字串輸出的是ASCII CODE
	}

}
