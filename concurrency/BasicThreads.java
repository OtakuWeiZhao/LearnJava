package concurrency;

// The most basic use of the Thread class.
public class BasicThreads {
	public static void main(String[] args) {
		Thread t = new Thread(new LiftOff());
		t.start();
		/**调用Thread对象的start()方法为该线程执行必须的初始化操作,
		 然后调用Runnable的run()方法以便在新的线程中启动该任务
		 start()迅速返回了*/
		System.out.println("waiting for LiftOff");
	}
}
/** Output:
 * waiting for LiftOff
#0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1), #0(Liftoff!), 
 * 
 * */