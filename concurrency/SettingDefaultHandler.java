package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 该处理器只有在不存在线程专有的未捕获异常处理器的情况下才会被调用
 * 系统会检查线程专有版本,如果没有则检查线程组是由有其专有的uncaughtException()方法
 * 如果也没有,再调用defaultUncaughtExceptionHandler
 */
public class SettingDefaultHandler {
	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtException());
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ExceptionThread());
	}
}
/**Output:
caught java.lang.RuntimeException
 */