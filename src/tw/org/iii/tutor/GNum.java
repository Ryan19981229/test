package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GNum extends JFrame implements ActionListener { // 繼承JFrame並實作ActionListener介面
	private JButton guess, restart; // 猜數字的按鈕元件
	private JTextField input; // 輸入猜測數字的文字輸入框元件
	private JTextArea log; // 顯示遊戲紀錄的文字區域元件
	private String answer; // 儲存正確答案的變數
	private int counter;

	public GNum() {
		super("猜數字遊戲"); // 設定視窗標題

		guess = new JButton("猜"); // 建立猜數字的按鈕
		restart = new JButton("清除"); // 建立清除的按鈕
		input = new JTextField(); // 建立文字輸入框
		log = new JTextArea(); // 建立文字區域

		setLayout(new BorderLayout()); // 設定視窗的佈局為邊界佈局
		JPanel top = new JPanel(new BorderLayout()); // 建立一個面板作為視窗的頂部佈局
		top.add(guess, BorderLayout.EAST); // 將猜數字按鈕放置於面板的東邊
		top.add(input, BorderLayout.CENTER); // 將文字輸入框放置於面板的中央
		top.add(restart, BorderLayout.WEST); // 將猜清除按鈕放置於面板的西邊

		add(top, BorderLayout.NORTH); // 將頂部佈局面板放置於視窗的北邊
		add(log, BorderLayout.CENTER); // 將文字區域放置於視窗的中央

		guess.addActionListener(this); // 將猜數字按鈕註冊事件監聽器
		restart.addActionListener(new ActionListener() { 

			public void actionPerformed(ActionEvent e) {

			}
		});// 將按鈕註冊事件監聽器

		setSize(640, 480); // 設定視窗大小
		setVisible(true); // 顯示視窗
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 設定視窗關閉動作為關閉程式

		newGame();
	}

	public static void main(String[] args) {
		new GNum(); // 建立GNum物件啟動遊戲

	}

	private void initView() {
		input.setFont(new Font(null, Font.BOLD, 24));
		log.setFont(new Font(null, Font.BOLD|Font.ITALIC, 20));
	}

	private void newGame() {
		answer = createAnswer(3);
		// System.out.println("answer = " + answer);
		log.setText("");
		input.setText("");
		counter = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String strInput = input.getText();
		if (isValid(strInput)) {

			counter++; // 增加次數

			String result = checkAB(strInput);
			log.append(String.format("%d. %s => %s \n", counter, strInput, result));
			input.setText("");

			if (result.equals("3A0B")) {
				JOptionPane.showMessageDialog(null, "恭喜老爺");
				newGame();
			} else if (counter == 2) {
				JOptionPane.showMessageDialog(null, "魯蛇: answer = " + answer);
				newGame();
			}
		}

	}
	private boolean isValid(String g) {
		
		return true;
	}

	private String checkAB(String g) {
		int A, B;
		A = B = 0; // 初始化A和B為0
		for (int i = 0; i < g.length(); i++) { // 逐一檢查每個猜測數字的位數
			char c = g.charAt(i); // 取得猜測數字的每個位數;
			if (c == answer.charAt(i)) { // 如果位數相同且位置相同，則A加1
				A++;
			} else if (answer.indexOf(c) != -1) { // 如果位數相同但位置不同，則B加1
				B++;
			}
		}
		return String.format("%dA%dB", A, B); // 回傳檢查結果，以"A"和"B"來表示猜中的位數和數字相同但位置不同的位數
	}

	private String createAnswer(int n) {
		int num = 10; // 總共有10個數字可供選擇
		int[] poker = new int[num]; // 建立一個陣列來儲存選擇的數字
		for (int i = 0; i < poker.length; i++) { // 初始化陣列，使其包含0到9的數字
			poker[i] = i;
		}
		for (int i = num - 1; i > 0; i--) { // 使用洗牌演算法將陣列中的數字亂序排列
			int rand = (int) (Math.random() * (i + 1)); // 隨機產生一個0到i的索引值
			// poker[rand] <=> poker[i]，將兩個索引值對應的數字交換位置
			int temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) { // 從亂序排列的陣列中取前n個數字，組成正確答案
			sb.append(poker[i]);
		}

		return sb.toString(); // 將正確答案轉換為字串型態並回傳
	}

}

class MyListener implements ActionListener { // 相當於按鈕被呼叫 ;先認識到按鈕才可以寫這個
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK");
	}
}
