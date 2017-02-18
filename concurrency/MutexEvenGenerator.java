package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Preventing thread collisions with mutexes
// 使用显式的Lock对象,Lock对象被显式得创建,锁定和释放
public class MutexEvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;
	private Lock lock = new ReentrantLock();

	// return语句必须在try子句中出现,以确保unlock()不会过早发生
	// 使数据过早暴露给第二个任务
	@Override
	public int next() {
		lock.lock();
		try {
			++currentEvenValue;
			Thread.yield();
			++currentEvenValue;
			return currentEvenValue;
		} finally {
			lock.unlock();
		}
	}
	public static void main(String[] args) {
		EvenChecker.test(new MutexEvenGenerator());
	}
}
