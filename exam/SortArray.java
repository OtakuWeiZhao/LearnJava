package exam;

import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class SortArray {
	public static final int RISE = 0;
	public static final int LOWER = 1;

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("请输入字符串程序: ");
		StringTokenizer token = new StringTokenizer(str, ",.;: ");
		int mode = SortArray.RISE;
		int count = token.countTokens();
		int array[] = new int[count];
		int index = 0;
		while (token.hasMoreTokens()) {
			try {
				array[index] = Integer.parseInt(token.nextToken());
				index++;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "输入非法字符", "错误警告", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		sort(array, mode);
		String result = new String();
		String modeString = new String();
		if (mode == SortArray.RISE)
			modeString = "升序排列的结果为: ";
		if (mode == SortArray.LOWER)
			modeString = "降序排列的结果为: ";
		for (int i = 0; i < array.length; i++)
			result = result + array[i] + ",";
		if (result != null)
			JOptionPane.showMessageDialog(null, result, modeString, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * 给数组排序的方法
	 * 
	 * @param array
	 *            - 需要排序的数组
	 * @param mode
	 *            - 排序的模式, 可以为RISE, LOWER
	 */
	public static void sort(int array[], int mode) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (mode == SortArray.RISE && array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
				if (mode == SortArray.LOWER && array[j] < array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}
}
