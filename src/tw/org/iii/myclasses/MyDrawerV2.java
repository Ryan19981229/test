package tw.org.iii.myclasses; // 宣告套件名稱 tw.org.iii.myclasses

import java.awt.BasicStroke;
import java.awt.Color; // 引用 java.awt.Color 類別
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter; // 引用 java.awt.event.MouseAdapter 類別
import java.awt.event.MouseEvent; // 引用 java.awt.event.MouseEvent 類別
import java.util.LinkedList;

import javax.swing.DebugGraphics;
import javax.swing.JPanel; // 引用 javax.swing.JPanel 類別

public class MyDrawerV2 extends JPanel { // 宣告 MyDrawer 類別，繼承 JPanel 類別
	private LinkedList<Line> lines, recycleBin; // 換型;這樣可以畫很多條線;陣列概念
	private Color nowColor;
	public MyDrawerV2() { // MyDrawer 類別的建構子
		setBackground(Color.yellow); // 設定背景顏色為黃色
		nowColor = Color.BLUE;
		lines = new LinkedList<>();
		recycleBin = new LinkedList<>();
		MyListener myListner = new MyListener(); // 建立一個 MyListener 物件
		addMouseListener(myListner); // 新增滑鼠事件監聽器
		addMouseMotionListener(myListner); // 新增滑鼠移動事件監聽器
	}
	public Color getColor() {
		return nowColor;
	}
	public void setColor(Color color) {
		nowColor = color;
	}
	public void clear() {
		lines.clear();
		recycleBin.clear();
		repaint();
	}
	
	public void undo() {
		if (lines.size()>0) {
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
	@Override
	protected void paintComponent(Graphics g) { // abstract class Graphics
		super.paintComponent(g);// 上一代先執行

		Graphics2D g2d = (Graphics2D) g;// 強制轉型把Graphics轉成Graphics2D
		g2d.setStroke(new BasicStroke(4));// 粗度
		for (Line line : lines) {
			g2d.setColor(line.getColor());
			for (int i = 1; i < line.size(); i++) {// 看有幾個點;有五個點畫出4條線
				Point p0 = line.getPoint(i - 1);
				Point p1 = line.getPoint(i);
				g2d.drawLine(p0.x, p0.y, p1.x, p1.y);// 找出兩個點一線
			}
		}
	}

	private class MyListener extends MouseAdapter {
		// 宣告 MyListener 類別，繼承 MouseAdapter 類別
		// public abstract class MouseAdapter 是***抽象類別***去賦予改寫方法
		// 巢狀類別 Ex.大工廠裡面有小工廠生產自己合適的輪胎:方便內部類別存取外部類別
		public void mousePressed(MouseEvent e) { // 當滑鼠按下時觸發
			recycleBin.clear();
			Line line = new Line(nowColor);
			
			
			Point point = new Point();
			point.x = e.getX(); point.y = e.getY(); // 在終端機中顯示滑鼠位置
			line.addPoint(point);
			lines.add(line);
			repaint(); //JPanel內部功能
		}

		@Override
		public void mouseDragged(MouseEvent e) { // 當滑鼠拖曳時觸發
			Point point = new Point();
			point.x = e.getX();
			point.y = e.getY(); // 在終端機中顯示滑鼠位置
			lines.getLast().addPoint(point); //最後面一條線
			repaint();
		}
	}
}

class Line{
	private Color color;
	private LinkedList<Point> points;
	Line(Color color){ //有傳參數建構式
		this.color = color;
		points = new LinkedList<>();
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public LinkedList<Point> getPoints() {
		return points;
	}
	public void setPoints(LinkedList<Point> points) {
		this.points = points;
	}
	
	public void addPoint(Point point) {
		points.add(point);
	}
	
	public Point getPoint(int index) {
		return points.get(index);
	}
	
	public int size() {
		return points.size();
	}
}