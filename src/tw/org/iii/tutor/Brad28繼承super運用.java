package tw.org.iii.tutor;

public class Brad28繼承super運用 {

	public static void main(String[] args) {
		Brad281 obj1 = new Brad281(2); //裡面有定義 就要一定回傳參數
		Brad282 obj2 = new Brad282(); 
		Brad283 obj3 = new Brad283(); 

	}

}
//所有類別(物件)都有建構式
class Brad281 extends Object{
	Brad281(int a){ //定義建構式
		//super(); //只會幫爸爸自動寫(第一道才有)
		
		//它的主要作用是在子類別的建構方法中呼叫父類別的建構方法，
		//以確保在建立子類別物件時能夠執行父類別的初始化邏輯。
		System.out.println("Brad281(int)");
	}
}

class Brad282 extends Brad281{
	Brad282(){ //因為沒有把爸爸祖宗初始化
		super(2);//不會幫兒子自動寫 且爸爸需要回傳參數
		System.out.println("Brad282(int)");
	}
}



class Brad283 extends Brad282{
	Brad283(){ //因為沒有把爸爸祖宗初始化
		//super();//不會幫兒子自動寫
		System.out.println("Brad283(int)");
	}
}

//以上程式碼是三個類別之間的繼承關係，並使用了 super() 在子類別的建構子中呼叫父類別的建構子，
//以確保在建立子類別物件時能夠執行父類別的初始化邏輯。