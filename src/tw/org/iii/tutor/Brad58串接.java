package tw.org.iii.tutor;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Brad58串接 {//FileInputStream => InputStreamReader =>BufferedReader

	public static void main(String[] args) {
		try {
			//FileInputStream fin = new FileInputStream("dir1\\Fstdata.csv");
			//其實這邊可以寫FileReader。
			FileReader reader = new FileReader("dir1\\\\Fstdata.csv");//出來資料型態是int
			//InputStreamReader ir = new InputStreamReader(fin); //提供了从字节到字符的编码（解码）的功能。
			BufferedReader br = new BufferedReader(reader);//讀取資料緩衝，效率更好
			String line;
			while ((line = br.readLine()) !=null) {//br.readLine()資料型態是string
				String[] row = line.split(",");
				System.out.println(row[1]+":"+ row[5]+";"+row[7]);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
