package tw.org.iii.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Brad52讀取檔案簡化版 {
	public static void main(String[] args) {
		try {
			File source = new File("dir1/file1.txt");
			FileInputStream fin = new FileInputStream(source);
			
			byte[] buf = new byte[(int)source.length()];
			fin.read(buf);//將檔案內容讀取到 buf 中。
			System.out.println(new String(buf));
			
			fin.close();
			//System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
