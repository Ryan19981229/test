package tw.org.iii.tutor;

public class Brad29繼承與創建new運用 {

	public static void main(String[] args) {
		Brad291 obj1 = new Brad291();
		Brad291 obj2 = new Brad292();
		Brad291 obj3 = new Brad293();
		Brad293 obj4 = new Brad293();
		//按照爸爸藍圖建立起來，所以不會有m2
		//繼承爸爸的m1運用自己的m1 ;不能用m2因為m2爸爸沒有
		doThing(obj4);
	}

	static void  doThing(Brad291 obj) { //向上轉型
		//要根據藍圖
		obj.m1();
	}
}

class Brad291 {
	void m1() {
		System.out.println("Brad291:m1()");
	}
}
class Brad292 extends Brad291 {
	void m1() {
		System.out.println("Brad292:m1()");
	}

	void m2() {
		System.out.println("Brad292:m2()");
	}
}
class Brad293 extends Brad291 {
	void m1() {
		System.out.println("Brad293:m1()");
	}

	void m2() {
		System.out.println("Brad293:m2()");
	}
}

