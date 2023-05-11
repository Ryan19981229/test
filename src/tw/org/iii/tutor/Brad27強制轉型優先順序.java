package tw.org.iii.tutor;

public class Brad27強制轉型優先順序 {

	public static void main(String[] args) {
		m1(1,(byte) 2); //沒寫是int; 能不能容納
	}
	static void m1(byte b1,byte b2) {
		System.out.println("1.m1(byte b1,byte b2)");
	}
	static void m1(byte b1,int b2) {
		System.out.println("2.m1(byte b1,int b2)");
	}
	static void m1(int b1,int b2) {
		System.out.println("3.m1(int b1,int b2)");
	}
	static void m1(int b1,byte b2) {
		System.out.println("4.m1(int b1,byte b2)");
	}
	
}
