package tw.org.iii.tutor;

public class Brad42例外異常V2 {

	public static void main(String[] args) {
		int a = 10, b = 1;
		int []c = {1,3,5};
		try {
			System.out.println(a/b);
			System.out.println(c[4]);
		}catch ( RuntimeException e ) {//嘗試捕捉;兩種類型都可以用
			System.out.println("Ooop");
		}

	}

}
