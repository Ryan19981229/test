package tw.org.iii.tutor;

public class Brad10減減a或a減減判斷 {

	public static void main(String[] args) {
		int a = 10, b = 3;
		if ( --a >= 10 || ++b <= 3) { 
			//a先減1再去判斷(--a:先減去1 a--: 先比對後減去1)
			// ||前面判斷成立後面不會比對
			System.out.printf("OK: a = %d; b = %d", a, b);
		}else {
			System.out.printf("XX: a = %d; b = %d", a, b);
		}
	}

}
