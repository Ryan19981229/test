package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad55寫入比較慢 {

	public static void main(String[] args) {
		try { //輸入輸出影片時，用此方法比較慢
			long start = System.currentTimeMillis();
			FileOutputStream fout = new FileOutputStream("dir2/brad.mkv");
			FileInputStream fin = new FileInputStream("dir1/eeit64.mkv");
			int b;
			while((b = fin.read()) !=-1) {
			//讀完一個寫一個
			}
			fin.close();
			fout.flush(); //output通常要用這個(建議寫一下)
			fout.close();
			System.out.println("finish:"+(System.currentTimeMillis()- start));
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
	}

}
