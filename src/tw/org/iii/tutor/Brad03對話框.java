package tw.org.iii.tutor;

import javax.swing.JOptionPane;

public class Brad03對話框 {
	public static void main(String[] args) {
		String strX = JOptionPane.showInputDialog("X = ?"); //提供了在圖形用戶界面中顯示對話框的功能。
		//strX 是一個字串變數，通過將從對話框中接收到的使用者輸入的字串賦值給它，存儲了使用者輸入的內容。
		String strY = JOptionPane.showInputDialog("Y = ?");
		
		int x = Integer.parseInt(strX); 
		int y = Integer.parseInt(strY);
		//程式碼使用 Integer.parseInt() 方法將字串轉換為整數。
		int r = x + y;
		
		JOptionPane.showMessageDialog(null,String.format("%d + %d = %d", x,y,r));
	}
		
	
}
 