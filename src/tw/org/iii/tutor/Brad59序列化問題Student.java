package tw.org.iii.tutor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import tw.org.iii.myclasses.Student;

public class Brad59序列化問題Student { //與物件做輸入與輸出的觀念
	public static void main(String[] args) {
		Student s1 = new Student("Brad", 52, 43, 64);
		System.out.println(s1.sum() + ":" + s1.avg());
		Student s2 = new Student("Andy", 72, 93, 87);
		System.out.println(s2.sum() + ":" + s2.avg());
		
		try {
			FileOutputStream fout = new FileOutputStream("dir1/s1");
			//建立檔案的輸出流
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			//物件序列化輸出流
			oout.writeObject(s1);
			oout.writeObject(s2);
			oout.flush();
			oout.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);//可以回傳錯誤訊息
		}
		
	}
}
