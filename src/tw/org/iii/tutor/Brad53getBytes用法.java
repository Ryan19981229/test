package tw.org.iii.tutor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Brad53getBytes用法 {

	public static void main(String[] args) {
		String data = "Hello World"; 
		try {
		FileOutputStream fout = new FileOutputStream("dir1/file2.txt",true);
		//這個也可以創建檔案;FileOutputStream(File file, boolean append)
		fout.write(data.getBytes());//依照目前的字元編碼方式將字串轉換為 byte 陣列;String方法
		fout.close();
		System.out.println("ok");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	}
}
//FileOutputStream(File file, boolean append)
//Creates a file output stream to write to the file represented by the 
//specified File object.
