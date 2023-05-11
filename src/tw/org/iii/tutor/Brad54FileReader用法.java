package tw.org.iii.tutor;

import java.io.FileReader;

public class Brad54FileReader用法{
	public static void main(String[] args) {
		try {
		FileReader reader = new FileReader("dir1/file1.txt"); //讀文字資料
		int c;
		while((c = reader.read()) !=-1) {
			System.out.print((char)c);
		}
		 reader.close();
		 
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
