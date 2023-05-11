package tw.org.iii.tutor;

import java.util.Scanner;

public class Brad02計算機 {
	public static void main(String[] args) {  //void 不能傳回返還值
		Scanner scanner = new Scanner(System.in); //產生物件，執行建構式
		//System.in 是 Java 標準庫中的一個 InputStream 物件，代表標準輸入流
		System.out.print("x = "); 
		int x = scanner.nextInt(); //用於從輸入中讀取下一個整數。
		System.out.print("y = ");
		int y = scanner.nextInt();
		int r1 = x + y;
		int r2 = x - y;
		int r3 = x * y;
		int r4 = x / y;
		int mod = x % y;
		System.out.printf("%d + %d = %d\n", x, y , r1); //格式化字串
		System.out.printf("%d - %d = %d\n", x, y , r2);
		System.out.printf("%d * %d = %d\n", x, y , r3);
		System.out.printf("%d / %d = %d.....%d", x, y , r4, mod);
	}
}
