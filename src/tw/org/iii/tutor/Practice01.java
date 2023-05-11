package tw.org.iii.tutor;

import tw.org.iii.myclasses.Practice010;


public class Practice01 extends Practice010{
	public static void main(String[] args) {
		Practice010 c = new Practice010(); // 新增物件初始化裡面如果沒有傳入值就是10
		//c.color = 4;     //如果在物件那邊寫private or protected，不行隨意更改
		System.out.println(c.color);
	}
}