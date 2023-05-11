package tw.org.iii.myclasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private BufferedImage[] imgs; // 用來存放球的圖片陣列
	private Timer timer; // 計時器，用於讓球移動並重新繪製畫面
	private int viewW, viewH; // JPanel 的寬度與高度
	private LinkedList<BallTask> balls; // 用來存放所有產生的球
	
	public MyPanel() {
		setBackground(Color.YELLOW); // 設定 JPanel 背景為黃色
		
		try {
			imgs = new BufferedImage[4];
			imgs[0] = ImageIO.read(new File("dir1/ball3.png")); // 載入球的圖片
			imgs[1] = ImageIO.read(new File("dir1/icons8-足球2-50.png")); // 載入球的圖片
			imgs[2] = ImageIO.read(new File("dir1/icons8-篮球-50.png")); // 載入球的圖片
			imgs[3] = ImageIO.read(new File("dir1/icons8-volleyball-50.png")); // 載入球的圖片
			
		} catch (IOException e) {
		}
		
		balls = new LinkedList<>(); // 初始化 LinkedList，用來存放球
		
		timer = new Timer(); // 初始化計時器
		timer.schedule(new RefreshView(), 0, 16); // 設定計時器每 16 毫秒就呼叫 RefreshView 執行繪圖
		addMouseListener(new MyMouseListener()); // 加入 MouseListener 監聽器
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW = getWidth(); viewH = getHeight(); // 取得 JPanel 的寬度與高度
		
		Graphics2D g2d = (Graphics2D)g;
		for (BallTask ball : balls) { // 迴圈處理所有球
			g2d.drawImage(imgs[ball.img], ball.x, ball.y, null); // 繪製球的圖片
		}
	}
	
	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			BallTask ball = new BallTask(e.getX()-32, e.getY()-32); // 在滑鼠點擊位置產生新球
			balls.add(ball); // 加入到 LinkedList 中
			timer.schedule(ball, 500, 30); // 設定新球移動的間隔與延遲
		}
	}
	
	private class RefreshView extends TimerTask { // 執行繪製 JPanel 的任務
		@Override
		public void run() {
			repaint(); // 重新繪製畫面
		}
	}
	
	private class BallTask extends TimerTask { // 執行移動球的任務
		public int x, y, dx, dy, img; // 球的位置、速度、圖片編號
		public BallTask(int x, int y) {
			this.x = x; this.y = y;
			dx = (int)(Math.random()*15) -7;
			dy = (int)(Math.random()*15) -7;
			img = (int)(Math.random()*4);
		}
		
		@Override
		public void run() {
			if (x <= 0 || x + 64 >= viewW) {
				dx *= -1;
			}
			if (y <= 0 || y + 64 >= viewH) {
				dy *= -1;
			}
			x += dx;
			y += dy;
		}
	}
	
}
