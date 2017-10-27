package exam;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener {
	private JTextField oneField, twoField, resultField;
	private JButton addButton, subtractButton, multiplyButton, divideButton, cleanButton;
	private JPanel panel1, panel2, panel3;

	public Calculator() {
		super("简易计算器");
		oneField = new JTextField(10);
		twoField = new JTextField(10);
		resultField = new JTextField(20);
		addButton = new JButton("+");
		subtractButton = new JButton("-");
		multiplyButton = new JButton("*");
		divideButton = new JButton("/");
		cleanButton = new JButton("CE");
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		oneField.setHorizontalAlignment(JTextField.RIGHT);
		twoField.setHorizontalAlignment(JTextField.RIGHT);
		resultField.setHorizontalAlignment(JTextField.RIGHT);
		resultField.setEditable(false);
		resultField.setBackground(Color.WHITE);
		resultField.setForeground(Color.RED);
		panel3.setLayout(new GridLayout(1, 4, 5, 5));
		panel3.add(addButton);
		panel3.add(subtractButton);
		panel3.add(multiplyButton);
		panel3.add(divideButton);
		panel3.add(cleanButton);
		addButton.addActionListener(this);
		subtractButton.addActionListener(this);
		multiplyButton.addActionListener(this);
		divideButton.addActionListener(this);
		cleanButton.addActionListener(this);
		panel1.add(new JLabel("输入x: "));
		panel1.add(oneField);
		panel2.add(new JLabel("输入y: "));
		panel2.add(twoField);
		this.setLayout(new FlowLayout());
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(resultField);
		this.setBounds(200, 100, 300, 200);
		this.setVisible(true);
		this.validate();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double x = 0;
		double y = 0;
		try {
			x = Double.parseDouble(oneField.getText());
			y = Double.parseDouble(twoField.getText());
		} catch (NumberFormatException e1) {
			resultField.setText("请输入数字字符");
		}
		if (e.getSource() == addButton)
			resultField.setText("X + Y = " + (x + y));
		else if (e.getSource() == subtractButton)
			resultField.setText("X - Y = " + (x - y));
		else if (e.getSource() == multiplyButton)
			resultField.setText("X * Y = " + (x * y));
		else if (e.getSource() == divideButton) {
			if (y == 0)
				resultField.setText("除数不能为0");
			else
				resultField.setText("X / Y = " + (x / y));
		}
		if (e.getSource() == cleanButton) {
			oneField.setText("");
			twoField.setText("");
			resultField.setText("");
		}
	}

	public static void main(String[] args) {
		new Calculator();
	}
}
