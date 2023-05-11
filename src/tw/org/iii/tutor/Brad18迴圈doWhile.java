package tw.org.iii.tutor;

public class Brad18迴圈doWhile {

	public static void main(String[] args) {
		
		int a = 10;
		do {
			System.out.println(a--);
		} while (a > 0);//裡面符合(true)回去
		System.out.println("----");
		while (a < 10) {

			System.out.println(a++);
		}
	}

}
