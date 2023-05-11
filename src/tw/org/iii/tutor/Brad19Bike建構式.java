package tw.org.iii.tutor;

import tw.org.iii.myclasses.Bike;

public class Brad19Bike建構式 {

	public static void main(String[] args) {
		Bike bike = new Bike();
		System.out.println(bike.getSpeed());
		bike.upSpeed(); bike.upSpeed(); bike.upSpeed(); bike.upSpeed();
		System.out.println(bike.getSpeed());	
		System.out.println(bike.getColor());	
	}
}