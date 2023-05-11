package tw.org.iii.tutor;

import java.io.File;

public class Brad47File用法V2 {

	public static void main(String[] args) {
		File root = new File(".");// . 代表本路徑
		System.out.println(root.getAbsolutePath()); //取得絕對路徑傳回字串
		File dir1 = new File("./dir1");//代表本路徑的dir1
		if (dir1.exists()) {
			System.out.println("ok");
		}else {
			System.out.println("XX");
		}
	}

}
