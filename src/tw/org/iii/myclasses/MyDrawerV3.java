package tw.org.iii.myclasses;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class MyDrawerV3 extends JPanel {
	private LinkedList<LinkedList<HashMap<String, Integer>>> lines, recycleBin;//最外層是多條線，中間層是一條線，內層是存點與值
	//HashMap 是物件
	//LinkedList<LinkedList<HashMap<String, Integer>>> lines：用於存儲所有繪製的線條，每一條線條是由多個點坐標組成的，每個點坐標是一個HashMap對象，其中包含x和y兩個鍵和對應的整型值。
	//LinkedList<LinkedList<HashMap<String, Integer>>> recycleBin：用於回收被刪除的線條，方便後續復原操作。
	private Color nowColor; //宣告一個Color變數，用於存儲當前畫筆的顏色。
	public MyDrawerV3() { //無傳參數建構式
		setBackground(Color.YELLOW);
		
		lines = new LinkedList<>();
		recycleBin = new LinkedList<>();//????????

		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
		//MyListener類別實現了畫圖應用程式的滑鼠事件處理邏輯，
		//並透過addMouseListener和addMouseMotionListener方法註冊到JPanel物件上，以監聽滑鼠事件並執行相應的處理邏輯。
	}
	public Color getColor() {
		return nowColor;
	}
	public void setColor(Color color) {
		this.nowColor = color;
	}
	public void clear() {
		lines.clear();
		repaint();
	}

	public void undo() {
		if (lines.size() > 0) {
			recycleBin.add(lines.removeLast());
			repaint();
		}
	}

	public void redo() {
		if (recycleBin.size() > 0) {
			lines.add(recycleBin.removeLast());
			repaint();
		}
	}

	public boolean saveLines(String fname) {
		try (FileOutputStream fin = new FileOutputStream(fname);
				ObjectOutputStream oout = new ObjectOutputStream(fin)) {
			oout.writeObject(lines);
			oout.flush();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean loadLines(String fname) {
		try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(fname))) {
			lines = (LinkedList<LinkedList<HashMap<String, Integer>>>) oin.readObject();
			repaint();
			recycleBin.clear();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public void saveJPEG() {
		BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();
		paint(g2d); // panel畫在g2d身上
		try {
			ImageIO.write(img, "jpeg", new File("dir1/lines.jpg"));
		} catch (Exception e) {
			System.out.println("e");
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(4));

		for (LinkedList<HashMap<String, Integer>> line : lines) {
			for (int i = 1; i < line.size(); i++) {
				HashMap<String, Integer> p0 = line.get(i - 1);
				HashMap<String, Integer> p1 = line.get(i);
				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
			}
		}

	}

	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			recycleBin.clear();
			LinkedList<HashMap<String, Integer>> line = new LinkedList<>();

			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			line.add(point);
			lines.add(line);

			repaint();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());

			lines.getLast().add(point);

			repaint();
		}
	}
	
}
