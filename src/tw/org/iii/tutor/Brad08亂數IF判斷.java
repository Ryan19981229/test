package tw.org.iii.tutor;

public class Brad08亂數IF判斷 {
	public static void main(String[] args) {
		double temp = Math.random() ;
		System.out.println(temp);
		int x = (int)(temp *101);
		System.out.println(x);
		if(x>=90) {
			System.out.println("A");
		}else if(x>=80) {
			System.out.println("B");
		}else if(x>=70) {
			System.out.println("C");
		}else if(x>=60) {
			System.out.println("D");
		}else {
	        System.out.println("E");
		}
				
			
		
	}
}
