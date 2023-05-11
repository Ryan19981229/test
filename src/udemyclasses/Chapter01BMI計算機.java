package udemyclasses;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Chapter01BMI計算機 {
	private static DecimalFormat df= new DecimalFormat("0.00");
	//使用 DecimalFormat，您可以控制數字的小數位數、千位分隔符、負數的符號、使用指數記數法等。

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("輸入體重(公斤):");
		double weight = scanner.nextDouble();
		System.out.println("輸入身高(公分):");
		double heigh = scanner.nextDouble();
		double bmi = Double.parseDouble(df.format(weight / (heigh*heigh*0.01*0.01)));
		System.out.println("你的BMI是:"+bmi);
		
		if(bmi<18.5) {
			System.out.println("體重過輕");
		}else if(bmi<24) {
			System.out.println("體重正常");
		}else if(bmi<30){
			System.out.println("體重微胖");
		}else {
			System.out.println("體重過胖，需減肥!");
		}
		
	}

}
