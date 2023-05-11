package tw.org.iii.tutor;

public class Brad01資料型態 {

	public static void main(String[] args) {  //程式執行進入點; main是指Brad01 括號裡面是參數
		//byte 2^8=>-123~127, bits
		//short 2^16=>65536 =>-32768~32768, 
		//int 2^32=>, -2,147,483,648 (-2^31) 到 2,147,483,647 (2^31 - 1)
		//long 2^64=>  很少用
		
		byte var1; //變數未初始化(沒有給值)，無法給執行
		byte var2, var3; //可以同時宣告
		byte var4 = 123;  
		
		System.out.println(var4);  // 快捷鍵:先打System，alt+/斜線
		
		int var5 = var4 +1; //後面做運算完會變成int
		short var6 = 321, var7= 123;
		int var8 = var6+var7; 
		//---------------------------------
		
		//變數名稱
		//[a-zA-Z$_][a-z A-Z 0-9_]*
		byte $_$ = 100;
		System.out.println($_$);
		int 變數1 = 123;
		System.out.println(變數1);
	}

}
