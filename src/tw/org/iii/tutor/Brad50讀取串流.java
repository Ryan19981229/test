package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Brad50讀取串流{

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/file1.txt");
			//建立串流
			int c ;//這邊一定要用int因為tead只能讀int
			while((c= fin.read()) != -1) {
				//the next byte of data, or -1 if the end of the file is reached.
				System.out.print((char)c); 
			}
//			System.out.println((char)c); //強制轉型成字元，不然他是回傳Ascii code
//			int b = fin.read();
//			System.out.println((char)b); //強制轉型成字元，不然他是回傳Ascii code
			fin.close();//打開串流就要關閉
			System.out.println("OK");

		} catch (FileNotFoundException e) { //或者Exception全包
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
