package tw.org.iii.myclasses;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class MyClock extends JLabel {
	private Timer timer;
	private SimpleDateFormat sdf;
	public MyClock() {
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		timer = new Timer();
		timer.schedule(new MyTask(), 0, 1000);
	}
	
	private class MyTask extends TimerTask {
		private int i;
		@Override
		public void run() {
			setText(sdf.format(new Date()));

		}
	}
}
