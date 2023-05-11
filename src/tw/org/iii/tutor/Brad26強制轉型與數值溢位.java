package tw.org.iii.tutor;

public class Brad26強制轉型與數值溢位 {

	public static void main(String[] args) {
		byte b1 = 123;
		int i1 = b1;
		int i2 = 128;
		byte b2 =(byte)i1; //強制轉型
		byte b3 =(byte)i2;
		System.out.println(b2);
		System.out.println("-----");
		System.out.println(b3); //喪失精度;因為超過範圍

	}

}
