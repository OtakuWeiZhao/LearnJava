package concurrency;

public class SerialNumberGenerator {
	// 基本上一个域可能会被多个任务同时访问,或者这个任务中至少有一个是
	// 写入任务,那么你就应该讲这个域设置为volatile,它会告诉编译器不要执行
	// 任何移除读取和写入操作的优化
	private static volatile int serialNumber = 0;

	// Java递增操作不是原子性的,并且涉及一个读一个写操作
	public static int nextSerialNumber() {
		return serialNumber++; // Not thread-safe
	}
}
