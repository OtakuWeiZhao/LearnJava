package exam;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

public class OpenAndSaveFile extends JFrame implements ActionListener {
	private JFileChooser fileChooser;
	private JPanel northPanel;
	private JButton openFileButton, saveFileButton;
	private JLabel label;
	private JTextArea textArea;
	private File file = null;

	public OpenAndSaveFile() throws HeadlessException {
		super("保存和打开文件");
		label = new JLabel();
		fileChooser = new JFileChooser();
		northPanel = new JPanel();
		openFileButton = new JButton("打开文件");
		saveFileButton = new JButton("保存文件");
		textArea = new JTextArea();
		fileChooser.addChoosableFileFilter(new MyFileFilter("txt"));
		openFileButton.addActionListener(this);
		saveFileButton.addActionListener(this);
		northPanel.add(openFileButton);
		northPanel.add(saveFileButton);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(new JScrollPane(textArea), BorderLayout.CENTER);
		this.add(label, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(50, 50, 500, 500);
		this.setVisible(true);
		this.validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == openFileButton) {
			int message = fileChooser.showOpenDialog(this);
			if (message == JFileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
				if (file != null) {
					label.setText(file.getAbsolutePath());
					showFile(file);
				}
			} else {
				label.setText("没有文件被选中");
			}
		}
		if (e.getSource() == saveFileButton) {
			int message = fileChooser.showSaveDialog(this);
			if (message == JFileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
				label.setText("保存到: " + file.getAbsolutePath());
				saveFile(file);
			} else {
				label.setText("没有文件被选中");
			}
		}
	}

	/**
	 * 打开指定文件,显示在文本区上
	 * 
	 * @param f
	 *            -文件对象
	 */
	public void showFile(File f) {
		try {
			FileReader file = new FileReader(f);
			BufferedReader in = new BufferedReader(file);
			String s = new String();
			textArea.setText("");
			while ((s = in.readLine()) != null) {
				textArea.append(s + "\n");
			}
			in.close();
		} catch (Exception e) {
			label.setText("读文件发生错误");
		}
	}

	/**
	 * 把文本区上的内容保存到指定文件
	 * 
	 * @param f
	 *            - 要保存的文件对象
	 */
	public void saveFile(File f) {
		try {
			FileWriter file = new FileWriter(f);
			BufferedWriter out = new BufferedWriter(file);
			out.write(textArea.getText(), 0, textArea.getText().length());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
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
		new OpenAndSaveFile();
	}
}
