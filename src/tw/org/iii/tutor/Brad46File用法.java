package tw.org.iii.tutor;

import java.io.File;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Brad46File用法 {
//輸入輸出可有可能是遠端 記憶體 資料夾
	public static void main(String[] args) {
		File file1 = new File("C:\\dir1");//window以為\t是跳脫字元;所以要再加上\
		if (file1.exists()) {
			System.out.println("ok");
		}else {
			System.out.println("XX");
		}

	}

}
//檢查檔案或目錄是否存在
//boolean exists = file1.exists();

//建立目錄
//boolean success = file1.mkdir();

//建立目錄（包含所有上層目錄）
//boolean success = file1.mkdirs();

//刪除檔案或目錄
//boolean success = file1.delete();

//取得檔案或目錄的名稱
//String name = file1.getName();

//取得檔案或目錄的絕對路徑
//String path = file1.getAbsolutePath();

//判斷是否為目錄
//boolean isDirectory = file1.isDirectory();

//取得目錄下的所有檔案和子目錄的名稱
//String[] files = file1.list();
