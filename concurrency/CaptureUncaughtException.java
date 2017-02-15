package concurrency;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ExceptionThread2 implements Runnable {

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("run() by " + t);
		System.out.println("eh = " + t.getUncaughtExceptionHandler());
		throw new RuntimeException();
	}
}

class MyUncaughtException implements UncaughtExceptionHandler {

	// 未捕获的异常通过UncaughtException来捕获的
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caught " + e);
	}
}

class HandlerThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		System.out.println(this + " creating new Thread");
		Thread t = new Thread(r);
		System.out.println("created " + t);
		t.setUncaughtExceptionHandler(new MyUncaughtException());
		System.out.println("eh = " + t.getUncaughtExceptionHandler());
		return t;
	}
}

public class CaptureUncaughtException {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
		exec.execute(new ExceptionThread2());
	}
}
/**Output:
concurrency.HandlerThreadFactory@f9f9d8 creating new Thread
created Thread[Thread-0,5,main]
eh = concurrency.MyUncaughtException@15b7986
run() by Thread[Thread-0,5,main]
eh = concurrency.MyUncaughtException@15b7986
caught java.lang.RuntimeException
 */