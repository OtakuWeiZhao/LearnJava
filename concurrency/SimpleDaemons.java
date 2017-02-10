package concurrency;

import java.util.concurrent.TimeUnit;

// Daemon threads don't prevent the program from ending
public class SimpleDaemons implements Runnable {

	@Override
	public void run() {
		try {
			while (true) {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			}
		} catch (InterruptedException e) {
			System.out.println("sleep() interrupted");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true); // Must call before start()
			daemon.start();
		}
		System.out.println("All daemons started");
		TimeUnit.MILLISECONDS.sleep(175);
	}
}
/**Output
All daemons started
Thread[Thread-5,5,main] concurrency.SimpleDaemons@a0dcd9
Thread[Thread-4,5,main] concurrency.SimpleDaemons@15f5897
Thread[Thread-1,5,main] concurrency.SimpleDaemons@186d4c1
Thread[Thread-6,5,main] concurrency.SimpleDaemons@1820dda
Thread[Thread-0,5,main] concurrency.SimpleDaemons@1cfb549
Thread[Thread-2,5,main] concurrency.SimpleDaemons@b162d5
Thread[Thread-9,5,main] concurrency.SimpleDaemons@1034bb5
Thread[Thread-7,5,main] concurrency.SimpleDaemons@c2ea3f
Thread[Thread-3,5,main] concurrency.SimpleDaemons@1d5550d
Thread[Thread-8,5,main] concurrency.SimpleDaemons@f9f9d8

 */