package tw.org.iii.tutor;
public class test3 {
//不用import test02 ， 因為在同一層
	public static void main(String[] args) {
		//test2 a = new test2();
		//System.out.println(a.pudding);
		System.out.println(test2.pika); //直接從test2 呼叫test2.pika ，因為public static
		// 沒有static 的話，需要初始化才能叫出來
	}
// 有沒有static有什麼差異
	
}
