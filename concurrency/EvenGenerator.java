package concurrency;

// When threads collide
public class EvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;

	@Override
	public int next() {
		++currentEvenValue;
		++currentEvenValue;
		return currentEvenValue;
	}

	// 一个任务有可能在另一个任务执行第一个对currentEvenValue的
	// 递增操作之后,但是没有执行第二个操作之前,调用next()方法
	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator());
	}
}
