package tw.org.iii.tutor;

import java.io.File;

public class Brad49檔案子目錄列出 {

	public static void main(String[] args) {
		File dir1 = new File("dir1");
		if (dir1.exists() && dir1.isDirectory()) { //是否為目錄資料夾
			File[] files = dir1.listFiles();//印出錄下的所有檔案和子目錄的名稱。
			for (File file : files) {
				String fname = file.getName();
				long size = file.length();
				String type = file.isDirectory()?"dir" :"file"; //傳送布林值
				System.out.println(fname+":"+size+":"+type);
			}
		}

	}

}
