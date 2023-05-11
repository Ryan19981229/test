package tw.org.iii.myclasses;

import java.io.Serializable;

//這是一個類別，不需要執行
public class Bike extends Object implements Serializable{ // Object為預設，可以不用寫
	protected double speed; // 這個腳踏車物件擁有速度這個屬性;要在前面打上public才可以在其他地方用
	// 用private 這樣不會讓使用者(執行檔)任意更改值
	// 用protected，繼承子類別可以用，但是執行方不能用(改)
	// 屬性
	private String color = "red"; //宣告color

	// 建構子
	public Bike() { // 建構子:不能有return; 有參數件各式
//		System.out.println("Bike()");
		this.color = "yellow"; //會覆蓋red
	}

	public String getColor() {
		return color;
	}

	public void upSpeed() { // 如果沒有打上public(存取修飾式) 只能用在同一個pkg
		this.speed = speed < 1 ? 1 : speed * 1.2;
	}

	public void downSpeed() {
		this.speed = speed < 1 ? 0 : speed * 0.7;
	}

	public double getSpeed() {
		return speed;
	}

	@Override
	public String toString() {
		return "Bike:" + speed;
	}

}
