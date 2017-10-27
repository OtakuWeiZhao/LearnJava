package exam;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MenuFrame extends JFrame implements ActionListener {
	private JMenuBar menubar;
	private JMenu file_menu, edit_menu, look_menu, arrangeIcons_menu, tool_menu;
	private JMenuItem new_item, open_item;
	private JMenuItem copy_item, paste_item;
	private JMenuItem refresh_item, byGroup_item, auto_item;
	private JTextArea textArea;

	public MenuFrame() {
		super("菜单应用程序");
		textArea = new JTextArea();
		menubar = new JMenuBar();
		file_menu = new JMenu("文件");
		edit_menu = new JMenu("编辑");
		look_menu = new JMenu("查看");
		arrangeIcons_menu = new JMenu("工具栏");
		tool_menu = new JMenu("排列图标");
		new_item = new JMenuItem("新建");
		open_item = new JMenuItem("打开");
		copy_item = new JMenuItem("复制");
		paste_item = new JMenuItem("粘贴");
		refresh_item = new JMenuItem("刷新");
		byGroup_item = new JMenuItem("按组排列");
		auto_item = new JMenuItem("自动排列");
		menubar.add(file_menu);
		menubar.add(edit_menu);
		menubar.add(look_menu);
		file_menu.add(new_item);
		file_menu.add(open_item);
		edit_menu.add(copy_item);
		edit_menu.add(paste_item);
		look_menu.add(refresh_item);
		look_menu.add(tool_menu);
		look_menu.add(arrangeIcons_menu);
		arrangeIcons_menu.add(byGroup_item);
		arrangeIcons_menu.add(auto_item);
		new_item.addActionListener(this);
		open_item.addActionListener(this);
		copy_item.addActionListener(this);
		paste_item.addActionListener(this);
		refresh_item.addActionListener(this);
		byGroup_item.addActionListener(this);
		auto_item.addActionListener(this);
		this.setJMenuBar(menubar);
		this.add(textArea, BorderLayout.CENTER);
		this.setBounds(50, 50, 250, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		JOptionPane.showMessageDialog(this, name + " 被选中", "提示", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {
		new MenuFrame();
	}
}
