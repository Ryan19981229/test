package tw.org.iii.tutor;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;

public class Brad73Timer {

	public static void main(String[] args) {
		Timer timer = new Timer();
		Brad731 task = new Brad731();
		timer.schedule(task, 3 * 1000);
		timer.schedule(new Brad732(timer), 5 * 1000);
		timer.schedule(new Brad733(), 0, 1000);
		System.out.println("main");
	}

}

class Brad731 extends TimerTask { // 抽象類別
	public void run() {
		System.out.println("ok");
	}
}

class Brad732 extends TimerTask {
	private Timer timer;

	Brad732(Timer timer) {
		this.timer = timer;
	}

	public void run() {
		timer.cancel();// 取消計時器所有已安排的任務
		timer.purge(); // 刪除所有已取消的任務。
		timer = null;
	}

}

class Brad733 extends TimerTask {
	private int i;

	public void run() {
		System.out.println(i++);
	}
}
