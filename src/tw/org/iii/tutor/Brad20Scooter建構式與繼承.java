package tw.org.iii.tutor;

import tw.org.iii.myclasses.Scooter;

public class Brad20Scooter建構式與繼承 {

	public static void main(String[] args) {
		Scooter s1 = new Scooter();//無參數建構式 ;根據類型藍圖創造物件
		s1.changeGear(2); //物件的方法
		//s1物件呼叫changeGear方法的時候傳入數字2
		//如果finction回傳值沒有被接
		s1.upSpeed();s1.upSpeed();
		System.out.println(s1.getSpeed());
	}

}
