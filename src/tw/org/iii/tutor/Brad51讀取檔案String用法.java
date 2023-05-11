package tw.org.iii.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Brad51讀取檔案String用法 {

	public static void main(String[] args) {
		try {
			File source = new File("dir1/file1.txt");
			FileInputStream fin = new FileInputStream(source); //可以讀全部資料內容
			//
			byte[] buf = new byte[(int)source.length()]; //執行幾個byte;
			int c;
			while((c= fin.read(buf)) != -1) {
				System.out.print(new String(buf,0,c)); 
				System.out.println((char)c); //強制轉型成字元，不然他是回傳Ascii code
				int b = fin.read();
				System.out.println((char)b); //強制轉型成字元，不然他是回傳Ascii code
				fin.close();//打開串流就要關閉
				System.out.println("OK");
			}
//			System.out.println((char)c); //強制轉型成字元，不然他是回傳Ascii code
//			int b = fin.read();
//			System.out.println((char)b); //強制轉型成字元，不然他是回傳Ascii code
//			fin.close();//打開串流就要關閉
//			System.out.println("OK");

		} catch (FileNotFoundException e) { //或者Exception全包
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
