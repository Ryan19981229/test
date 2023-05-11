package tw.org.iii.tutor;

public class Brad33創建new {

	public static void main(String[] args) {
		int a = 10;
		Integer b = new Integer(10); //往後版本不能使用 
		Integer c = new Integer("10"); 
		Integer d = Integer.parseInt("10");
		Integer e = 10; //auto-boxing自動封裝
		System.out.println(b.doubleValue());

//		System.out.println(b+c); //auto-unboxing  自動解封箱子。
	}

}
