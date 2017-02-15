package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable {

	@Override
	public void run() {
		throw new RuntimeException();
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ExceptionThread());
	}
}
/**Output:
Exception in thread "pool-1-thread-1" java.lang.RuntimeException
	at concurrency.ExceptionThread.run(ExceptionThread.java:10)
	at java.util.concurrent.ThreadPoolExecutor$Worker.runTask(ThreadPoolExecutor.java:886)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:908)
	at java.lang.Thread.run(Thread.java:619)

 */