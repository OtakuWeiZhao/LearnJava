package exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

public class CheckBrackets extends JFrame implements ActionListener, ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFileChooser fileChooser;
	private JButton openFileButton;
	private JComboBox comboBox;
	private JTextField showRowStringField;
	private JTextField showMessageField;
	private JTextArea textArea;
	private JPanel northPanel, control_panel;
	private String rowString[];
	private File file = null;

	public CheckBrackets() {
		super("检测圆,花括号匹配程序");
		fileChooser = new JFileChooser(System.getProperty("user.dir"));
		openFileButton = new JButton("打开文件");
		showRowStringField = new JTextField();
		showMessageField = new JTextField(20);
		textArea = new JTextArea();
		comboBox = new JComboBox();
		northPanel = new JPanel();
		control_panel = new JPanel();
		rowString = new String[1000];
		fileChooser.addChoosableFileFilter(new MyFileFilter("txt"));
		textArea.setLineWrap(true);
		showRowStringField.setEditable(false);
		showRowStringField.setBackground(Color.WHITE);
		showMessageField.setEditable(false);
		showMessageField.setBackground(Color.WHITE);
		openFileButton.addActionListener(this);
		comboBox.addItemListener(this);
		comboBox.addItem("请选择");
		control_panel.add(openFileButton);
		control_panel.add(new JLabel(" 选择代码行:"));
		control_panel.add(comboBox);
		control_panel.add(new JLabel("检测结果:"));
		control_panel.add(showMessageField);
		northPanel.setLayout(new GridLayout(2, 1, 10, 10));
		northPanel.add(control_panel);
		northPanel.add(showRowStringField);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(new JScrollPane(textArea), BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(50, 50, 550, 500);
		this.setVisible(true);
		this.validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		showMessageField.setText("");
		int message = fileChooser.showOpenDialog(this);
		if (message == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			comboBox.removeAllItems();
			comboBox.addItem("请选择");
			readFile(file);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		int index = comboBox.getSelectedIndex();
		if (index >= 1) {
			showRowStringField.setText(rowString[index - 1]);
			char c[] = rowString[index - 1].toCharArray();
			int count1 = 0;
			int count2 = 0;
			for (int i = 0; i < c.length; i++) {
				if (c[i] == '{')
					count1++;
				if (c[i] == '}')
					count1--;
				if (c[i] == '(')
					count2++;
				if (c[i] == ')')
					count2--;
				System.out.println("大括号" + count1 + ",小括号:" + count2);
			}
			if (count1 != 0)
				showMessageField.setText("第" + index + "行, 大括号匹配错误");
			else if (count2 != 0)
				showMessageField.setText("第" + index + "行, 小括号匹配错误");
			else if (count1 != 0 && count2 != 0)
				showMessageField.setText("第" + index + "行, 大,小括号都匹配错误");
			else if (count1 == 0 && count2 == 0)
				showMessageField.setText("括号匹配正确");
		}
	}

	public void readFile(File f) {
		if (f != null) {
			try {
				FileReader file = new FileReader(f);
				BufferedReader in = new BufferedReader(file);
				String s = new String();
				int i = 0;
			} catch (Exception e) {
				System.out.println("" + e.toString());
			}
		}
	}

	class MyFileFilter extends FileFilter {
		String ext;

		public MyFileFilter(String t) {
			ext = t;
		}

		@Override
		public boolean accept(File file) {
			if (file.isDirectory())
				return true;
			String fn = file.getName();
			int index = fn.lastIndexOf('.');
			if (index > 0 && index < fn.length() - 1l) {
				String extension = fn.substring(index + 1).toLowerCase();
				if (extension.equals(ext))
					return true;
			}
			return false;
		}

		@Override
		public String getDescription() {
			if (ext.equals("java"))
				return "JAVA Source File(*.java)";
			if (ext.equals("txt"))
				return "Txt File(*.txt)";
			return "";
		}

	}

	public static void main(String[] args) {
		new CheckBrackets();
	}
}
