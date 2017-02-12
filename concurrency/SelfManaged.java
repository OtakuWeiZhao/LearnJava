package concurrency;

// A Runnable containing its own driver Thread 
public class SelfManaged implements Runnable {
	private int countDown = 5;
	private Thread t = new Thread(this);

	public SelfManaged() {
		// start在构造器中调用
		/*在构造器中启动线程可能会出现问题,因为另一个任务可能会在构造器
		结束之前开始执行,该任务访问处于不稳定状态的对象,这是优选Executor
		而不是显式地创建Thread对象的另一个原因*/
		t.start();
	}

	@Override
	public String toString() {
		return Thread.currentThread().getName() + "[=" + countDown + "]. ";
	}

	@Override
	public void run() {
		while (true) {
			System.out.print(this);
			if (--countDown == 0)
				return;
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++)
			new SelfManaged();
	}
}
/**
 * Thread-0[=5]. Thread-2[=5]. Thread-0[=4]. Thread-0[=3]. Thread-0[=2].
 * Thread-1[=5]. Thread-2[=4]. Thread-1[=4]. Thread-0[=1]. Thread-1[=3].
 * Thread-1[=2]. Thread-3[=5]. Thread-3[=4]. Thread-2[=3]. Thread-4[=5].
 * Thread-3[=3]. Thread-1[=1]. Thread-3[=2]. Thread-3[=1]. Thread-4[=4].
 * Thread-4[=3]. Thread-4[=2]. Thread-4[=1]. Thread-2[=2]. Thread-2[=1].
 */