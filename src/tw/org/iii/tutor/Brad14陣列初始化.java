package tw.org.iii.tutor;

public class Brad14陣列初始化 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		int[] b;
		a = 1;
		b = new int[3]; //default是0
		System.out.println(b.length);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		b[0] = 123;
		b[2] = -4;
		System.out.println("------------");
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}

	}

}
