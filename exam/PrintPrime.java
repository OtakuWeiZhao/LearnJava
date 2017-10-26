package exam;

import javax.swing.JOptionPane;

public class PrintPrime {
	private int number;
	private String result = "";

	public PrintPrime() {
		number = getIntegerNumber("输入整数n", 0);
		if (number < 0) {
			return;
		} else {
			for (int i = 2; i <= number; i++) {
				if (isPrimeNumber(i)) {
					result += i + " ";
				}
			}
		}
		JOptionPane.showMessageDialog(null, number + "之前的所有素数为:\n`"+ result + "`", "显示结果",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public int getIntegerNumber(String message, int min) {
		String str = JOptionPane.showInputDialog(null, message, "提示信息", JOptionPane.INFORMATION_MESSAGE);
		int number = -1;
		try {
			number = Integer.parseInt(str);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "输入非数字字符\n程序结束", "错误警告", JOptionPane.ERROR_MESSAGE);
			return -1;
		}
		if (number < min) {
			JOptionPane.showMessageDialog(null, "输入的数不符合规则, 不是正整数\n程序结束", "错误警告", JOptionPane.ERROR_MESSAGE);
			return -1;
		} else
			return number;
	}

	public boolean isPrimeNumber(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		new PrintPrime();
	}
}
