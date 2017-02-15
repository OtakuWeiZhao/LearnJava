package concurrency;

// User interface responsiveness
class UnresponsiveUI {
	private volatile double d = 1;

	public UnresponsiveUI() throws Exception {
		while (d > 0)
			d = d + (Math.PI + Math.E) / d;
		System.in.read(); // Never gets here
	}
}

public class ResponsiveUI extends Thread {
	private static volatile double d = 1;

	public ResponsiveUI() {
		setDaemon(true);
		start();
	}

	@Override
	public void run() {
		while (true) {
			d = d + (Math.PI + Math.E) / d;
		}
	}

	public static void main(String[] args) throws Exception {
		// UnresponsiveUI在一个无限循环里执行运算,所以不可能达到
		// 读取控制台输入的那一行
//		new UnresponsiveUI(); // Must kill this process
		// 要想让程序有响应,得把计算程序放在run()方法中
		new ResponsiveUI();
		System.in.read();
		System.out.println(d);
	}

}
