package tw.org.iii.tutor;

import javax.annotation.processing.SupportedSourceVersion;

public class Brad72示範執行緒{
//執行序要好好完成，時間精準度不高，與之相對的是Timer
	public static void main(String[] args) {
		Brad721 obj1 = new Brad721("A");
		Brad721 obj2 = new Brad721("B");
		Brad722 obj3 = new Brad722("C");// 還不是執行序，只是runnable
		Thread t1 = new Thread(obj3);
		obj1.start();//要啟動一個Thread，可以使用start()方法
		//obj3.run();//物件方法
		t1.start(); //開了一個執行緒
		obj2.start();
		System.out.println("main");
	}

}

class Brad721 extends Thread { //一個Thread一個執行緒 少用
	String name;

	Brad721(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + "." + i);

			try {
				Thread.sleep(100);//

			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}



class Brad722  implements Runnable  {//Runnable 是一個介面;優點:可以再寫繼承
	//Runnable 可以更好地分離多執行緒的邏輯和執行緒本身，從而更好地控制多執行緒的執行和調度。
	String name;

	
	Brad722(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + "." + i);

			try {
				Thread.sleep(100);//

			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}