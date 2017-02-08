package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
	public static void main(String[] args) {
		// 使用Executor来代替显示地创建Thread对象
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
			exec.execute(new LiftOff());
		// shutdown方法可以防止新任务被提交给这个Executor
		exec.shutdown();
	}
}
/**Output:
#3(9), #4(9), #2(9), #1(9), #0(9), #1(8), #2(8), #4(8), 
#3(8), #4(7), #2(7), #1(7), #0(8), #1(6), #2(6), #4(6), 
#3(7), #4(5), #2(5), #1(5), #1(4), #1(3), #1(2), #2(4), 
#0(7), #2(3), #1(1), #4(4), #3(6), #4(3), #1(Liftoff!), #2(2), 
#0(6), #4(2), #2(1), #0(5), #4(1), #2(Liftoff!), #3(5), #4(Liftoff!), 
#0(4), #3(4), #0(3), #3(3), #0(2), #3(2), #0(1), #0(Liftoff!), #3(1), #3(Liftoff!), 
 */