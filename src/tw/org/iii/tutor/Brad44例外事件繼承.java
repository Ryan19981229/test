package tw.org.iii.tutor;

import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.zone.ZoneRulesException;

public class Brad44例外事件繼承 {

	public static void main(String[] args) {
		

	}

}

class Brad441 {
	void m1() throws Exception,Exception{
		m2();
	}
	void m2() throws FontFormatException,Exception{ //如果不處理，要交給上一個人去處理
//		try {
			m3(0);
//		}catch(Exception e) {}
		
	} //可以打Exception或FontFormatException
	  //對外宣稱層級可以大於裡面例外宣稱
	void m3(int a) throws FontFormatException,FileNotFoundException{ //裡面有兩個就要宣稱兩個
		if (a>0) {
			throw new FontFormatException(null);
		}else {
			throw new FileNotFoundException(null);
		}
	}
}

class Brad442 extends Brad441{
	void m3(int b) throws FontFormatException, ZoneRulesException{
		//子類別拋出例外數量***不能大於***父類別且層級不能大於父類別
		
	}
	
	
	
}