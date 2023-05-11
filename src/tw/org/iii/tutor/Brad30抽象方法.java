package tw.org.iii.tutor;

public class Brad30抽象方法 {

	public static void main(String[] args) {//抽象類別無法建構出物件實體
		//Brad302 obj1 = new Brad301(); //抽象類別無法建構出物件實體;事情做到一半不能產生物件
		Brad302 obj2 = new Brad302();//用子類別來做
		Brad303 obj3 = new Brad303();
		obj2.m2();
		obj3.m2();
		
	}

}

abstract class Brad301 { // 一個類別定義
	Brad301 (int a){
		System.out.println("Brad301()");
	}//沒辦法建構出並不代表沒有建構式
	void m1() {
		System.out.println("Brad301:m1()");
	}
	abstract void m2();//***抽象方法;只要這裡有抽象方法,外面要說是抽象類別***
	//換句話說沒有抽象方法，可以有抽象類別
}

class Brad302 extends Brad301{//繼承抽象類別;需要寫出m2要幹嘛才能使用爸爸的m1。
	Brad302 (){
		super(3);
		System.out.println("Brad302()");
	}
	void m2() {
		System.out.println("Brad301:m2()");
	}
}

class Brad303 extends Brad301{//繼承抽象類別;需要寫出m2要幹嘛才能使用爸爸的m1。
	Brad303 (){
		super(2);
		System.out.println("Brad303()");
	}
	void m2() {
		System.out.println("Brad301:m3()");
	}
}
