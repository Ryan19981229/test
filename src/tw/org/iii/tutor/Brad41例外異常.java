package tw.org.iii.tutor;

public class Brad41例外異常 {
	//例外異常是處理機制
	public static void main(String[] args) {
		int a = 10, b = 0;
		int []c = {1,3,5};
		try {
			System.out.println(a/b);
			System.out.println(c[4]);
		}catch ( ArithmeticException ae ) {//嘗試捕捉
			System.out.println("Ooop");
		}catch(ArrayIndexOutOfBoundsException ie) {
			System.out.println("not much");
		}
	}
}
