package gui;
import java.awt.*;
public abstract class ActiveActer implements Runnable{

	int min_time;
	int max_time;
	Thread thread;
	public ActiveActer(Color color, int min_time, int max_time) {
		this.min_time = min_time;
		this.max_time = max_time;
		initialize();
	}
	
	public abstract void paint(Graphics g, int a, int b);
	
	public void initialize() {
		thread = new Thread( this);
		thread.start();
	}

	public void wait_time() throws InterruptedException{
		long time = (long) (min_time + (max_time - min_time) * Math.random());
		thread.sleep(time); // stavi da cekanje bude izmedju!
		return;
	}
	
	
	
	public synchronized void finish() {
		if (thread == null) {
			return;
		}
		thread.interrupt();
	
		try {
			thread.join();
			thread = null;
		} catch (InterruptedException e) {
		}
}
}
