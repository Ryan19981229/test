package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad56寫入比較快 {

	public static void main(String[] args) {
		try { //輸入輸出影片時，用此方法比較快
			long start = System.currentTimeMillis();
			FileOutputStream fout = new FileOutputStream("dir2/brad.mkv");
			FileInputStream fin = new FileInputStream("dir1/eeit64.mkv");
			int len;
			byte[] buf = new byte[4*1024]; //4k解析度
			while((len =  fin.read()) !=-1) {
				fout.write(buf,0,len);//寫入
			}
			fin.close();
			fout.flush();
			fout.close();
			System.out.println("finish:"+(System.currentTimeMillis()- start));
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
	}

}
