package tw.org.iii.tutor;

public class Brad07亂數RANDOM {
	public static void main(String[] args) {
		double temp = Math.random() ;
		System.out.println(temp);
		int x = (int)(temp *101);
		System.out.println(x);
		if(x>60) {
			System.out.println("Pass");
		}else {
			System.out.println("Down");
		}
	}
}
