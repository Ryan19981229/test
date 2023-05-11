package tw.org.iii.tutor;

interface ABC {

 public void test();

}


class A implements ABC {
	public void test() {
		System.out.println("aaaa");
	}
	public void apple() {
		System.out.println("apple");
	}
}

class B implements ABC  {
	public void test() {
		System.out.println("bbbb");
	}
}

class Main {
	ABC f() {
		return new A();
	}
	
	void m(ABC z) {
		z.test();
	}
	
	void run() {
		ABC x = f(); //f()PreparedStatement
		x.test();
		
		m(new A());
		m(new B());
	}
}