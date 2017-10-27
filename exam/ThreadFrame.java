package exam;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ThreadFrame extends JFrame implements ActionListener, Runnable {
	private JPanel panel;
	private JButton button;
	private JTextArea textArea;
	private Thread fatherThread, motherThread, childOneThread, childTwoThread, childThreeThread;
	private int peachCount = 0;
	public static final int EAT = 0;// 盘子数量
	public static final int PRODUCE = 1;// 动作, 吃桃子
	public static final int COUNTDISH = 5;// 盘子可以放桃子总数
	public static final int COUNT = 50;// 总的执行次数,防止程序一直执行下去
	private int number = 0;

	public ThreadFrame() {
		super("多线程应用程序");
		fatherThread = new Thread(this);
		motherThread = new Thread(this);
		childOneThread = new Thread(this);
		childTwoThread = new Thread(this);
		childThreeThread = new Thread(this);
		panel = new JPanel();
		button = new JButton("开始程序");
		textArea = new JTextArea();
		button.addActionListener(this);
		panel.add(button);
		this.add(panel, BorderLayout.NORTH);
		this.add(new JScrollPane(textArea), BorderLayout.CENTER);
		this.setBounds(10, 10, 500, 700);
		this.setVisible(true);
		this.validate();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fatherThread.start();
		motherThread.start();
		childOneThread.start();
		childTwoThread.start();
		childThreeThread.start();
	}

	@Override
	public void run() {
		if (Thread.currentThread() == fatherThread) {
			while (number < COUNT) {
				dish(PRODUCE, "爸爸 -");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				number++;
			}
		}
		if (Thread.currentThread() == motherThread) {
			while (number < COUNT) {
				dish(PRODUCE, "妈妈 -");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				number++;
			}
		}
		if (Thread.currentThread() == childOneThread) {
			while (number < COUNT) {
				dish(EAT, "老大 -");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				number++;
			}
		}
		if (Thread.currentThread() == childTwoThread) {
			while (number < COUNT) {
				dish(EAT, "老二 -");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				number++;
			}
		}
		if (Thread.currentThread() == childThreeThread) {
			while (number < COUNT) {
				dish(EAT, "老三 -");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				number++;
			}
		}
	}

	/**
	 * 对盘子的操作方法
	 * 
	 * @param action
	 *            - 动作,分为EAT, 和放PRODUCE
	 * @param name
	 *            - 动作的产生者
	 */
	public synchronized void dish(int action, String name) {
		if (action == EAT) {
			while (true) {
				if (peachCount >= 1)
					break;
				else {
					try {
						textArea.append("eat peach wait " + name + "吃桃子等待\n");
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			peachCount--;
			textArea.append(name + "吃掉一个桃子\n");
			textArea.append("----------------盘子中桃子数量为:" + peachCount + "个\n");
		}
		if (action == PRODUCE) {
			while (true) {
				if (peachCount < COUNTDISH)
					break;
				else {
					try {
						textArea.append("produce peach wait" + name + "放桃子等待\n");
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			peachCount++;
			textArea.append(name + "放上一个桃子");
			textArea.append("----------------盘子中桃子数量为:" + peachCount + "个\n");
		}
		notify();
	}

	public static void main(String[] args) {
		new ThreadFrame();
	}
}
