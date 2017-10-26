package exam;

import javax.swing.JOptionPane;

public class StaChar {
	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("请输入字符串:");
		char[] c = str.toCharArray();
		int numberCount = 0;
		int letterCount = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] < '9' && c[i] > '0')
				numberCount++;
			else if ((c[i] > 'A' && c[i] < 'Z') || (c[i] > 'a' && c[i] < 'z'))
				letterCount++;
		}
		String result = "输入内容: \n" + str + "\n数字字符: " + numberCount + "个;" + "\n字母:" + letterCount + "个";
		JOptionPane.showMessageDialog(null, result, "结果", JOptionPane.INFORMATION_MESSAGE);
	}
}
