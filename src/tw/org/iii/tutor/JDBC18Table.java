package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tw.org.iii.myclasses.MyTable;

public class JDBC18Table extends JFrame {// 存粹處理版面事情
	private MyTable myTable;
	private JButton del;

	public JDBC18Table() {

		setLayout(new BorderLayout());
		JPanel top = new JPanel(new FlowLayout());
		del = new JButton("Del");
		top.add(del);
		add(top, BorderLayout.NORTH);
		del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				delData();
			}
		});

		try {
			myTable = new MyTable();
			JScrollPane jsp = new JScrollPane(myTable);
			add(jsp, BorderLayout.CENTER);

			setSize(800, 640);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		} catch (Exception e) {
			System.exit(123);
		}
	}

	private void delData() {
		myTable.delRow();
	}

	public static void main(String[] args) {
		new JDBC18Table();
	}

}
