package tw.org.iii.tutor;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Brad21JFrame extends JFrame {// 繼承 不用初始化
//	private JButton b1;
	public Brad21JFrame(){ // 方法呼叫(建構式) 用JFrame裡面的物件
		System.out.println("Brad21()");
		setSize(640, 480);
		setVisible(true); // 視窗顯示
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 關閉後自己結束
		setTitle("我的視窗");
		setLayout(new FlowLayout()); // 自動處理版面問題
		JButton b1 = new JButton("按我");
		b1.setText("哈哈");
		add(b1);
	}

	public static void main(String[] args) {
		new Brad21JFrame(); // 物件;有建構子初始化
	}
}
