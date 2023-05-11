package tw.org.iii.tutor;

import tw.org.iii.myclasses.BCrypt;

public class Brad75密碼雜湊函數 {

	public static void main(String[] args) {
		String passwd = "123456";//
		String hwPasswd = BCrypt.hashpw(passwd,BCrypt.gensalt());
		//BCrypt 是一種密碼雜湊函數
		//hashpw() 方法使用密碼和鹽值來計算出密碼的雜湊值，並返回這個雜湊值作為加密後的密碼。
		//gensalt() 是用於生成鹽值的方法。鹽值是在密碼雜湊過程中添加的一些隨機數據
		System.out.println(hwPasswd);
		
		if (BCrypt.checkpw("123456", hwPasswd)) {
			System.out.println("ok");
		}else {
			System.out.println("XX");
		}

	}

}
