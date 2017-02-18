package concurrency;

public class SychronizedEvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;

	// 第一个进入next任务将获得锁,任何其他试图获取锁的方式
	// 都从其开始尝试之时被阻塞,直至第一个任务释放锁
	@Override
	public synchronized int next() {
		++currentEvenValue;
		// 一高在currentEvenValue是奇数状态时切换
		// 上下文的可能性
		Thread.yield(); // Cause failure faster
		++currentEvenValue;
		return currentEvenValue;
	}

	public static void main(String[] args) {
		EvenChecker.test(new SychronizedEvenGenerator());
	}
}
