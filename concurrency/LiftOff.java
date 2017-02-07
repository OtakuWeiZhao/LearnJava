package concurrency;

// Demonstration of the Runnable interface
public class LiftOff implements Runnable {
	protected int countDown = 10;// Default
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff() {
	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		// id可以区分任务的多个实例,它是final的
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
	}

	/**
	 * 	 要想定义任务,只需实现Runnable接口病编写run()方法,
	 * 使该任务可以执行你的命令.
	 * run()方法总有某种形式的循环
	 * run()中静态方法Thread.yield()的调用时对 线程调度器 的一种建议
	 * 它在声明:"我已经执行完生命周期中最重要的一部分了,此刻是切换给
	 * 其他任务执行一段时间的大好时机"
	 * */
	@Override
	public void run() {
		while (countDown-- > 0) {
			System.out.print(status());
			Thread.yield();
		}
	}

}
