package tw.org.iii.tutor;

public class Brad11XOR位元運算子 {

	public static void main(String[] args) {
		int a = 3;
		int b = 2;
		System.out.println(a ^ b);  //二進位 XOR 位元運算子: 
		//00 or 11 =0; 01 or 10 = 1
		
		a = a ^ b;	// a = ? 
		b = a ^ b;	// 
		a = a ^ b;
		System.out.printf("a = %d; b = %d\n", a, b);
		
		a = a + b;	// a = 5
		b = a - b;	// b = 3
		a = a - b;	// a = 2
		System.out.printf("a = %d; b = %d\n", a, b);
		
				
	}

}
