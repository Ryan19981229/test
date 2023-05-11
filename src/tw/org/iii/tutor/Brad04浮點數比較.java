package tw.org.iii.tutor;

public class Brad04浮點數比較 {
	public static void main(String[] args) {
		float var1 = 123;
		float var2 = 12.3f;//float浮點數要加上f
		double var3 = 123;
		double var4 = 12.3;
		double var5 = 10/3.0;
		System.out.println(var2);
		float var6 = 10/3.0f;
		System.out.println(var6);
		//精度不同：float變數使用32位元（4個位元組）來表示浮點數，
		//而double變數使用64位元（8個位元組）來表示浮點數。
		//因此，double變數可以表示比float更大和更精確的數字，但是會佔用更多的記憶體空間。
	}
	
}
