package second;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ChangePanel extends JFrame implements ActionListener {
	JMenuItem easylevel;
	JMenuItem normallevel;
	JMenuItem hardlevel;
	MyPanel p;
	static JMenuItem look1;
	static JTextField tx;
	static int times = 0;
	// Boolean state;
	int x = 0, y = 0;//

	public ChangePanel() {
		super("记忆");
		JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("难度");
		JMenu look = new JMenu("提示");
		look1 = new JMenuItem("提示1");
		easylevel = new JMenuItem("简单");
		normallevel = new JMenuItem("中等");
		hardlevel = new JMenuItem("困难");
		file.add(easylevel);
		file.add(normallevel);
		file.add(hardlevel);
		bar.add(file);
		look.add(look1);
		bar.add(look);

		easylevel.addActionListener(this);
		normallevel.addActionListener(this);
		hardlevel.addActionListener(this);

		this.add(bar, BorderLayout.NORTH);
		this.setBounds(100, 100, 600, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tx = new JTextField("test");
		tx.setText("时间：0 s");
		tx.setFont(new Font("楷体", Font.BOLD, 30));
		tx.setHorizontalAlignment(JTextField.CENTER);

		// tx.setEditable(false);
		tx.setForeground(Color.red);

		this.add(tx, BorderLayout.SOUTH);

		validate();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChangePanel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == easylevel) {
			System.out.println("easy level");
			if (p != null){
				if (p.timers != null){
					p.timers.stop();
					System.out.println("killtimes");
				}
				this.remove(p);
				
			}
			times=0;
			x = 5;
			y = 5;
			changePanel(x, y);
			tx.setText("时间：0 s,找出5个相同图标");
			this.revalidate();
		} else if (e.getSource() == normallevel) {
			System.out.println("normal level");
			if (p != null){
				if (p.timers != null){
					p.timers.stop();
					System.out.println("killtimes");
				}
				this.remove(p);
				
			}
			times=0;
			x = 6;
			y = 6;
			changePanel(x, y);
			tx.setText("时间：0 s,找出6个相同图标");
			this.revalidate();
		} else if (e.getSource() == hardlevel) {
			System.out.println("hard level");
			if (p != null){
				if (p.timers != null){
					p.timers.stop();
					System.out.println("killtimes");
				}
				this.remove(p);
				
			}
			times=0;
			x = 7;
			y = 7;
			changePanel(x, y);
			tx.setText("时间：0 s,找出7个相同图标");
			this.revalidate();
		}

	}
	void changePanel(int x, int y) {
		// TODO Auto-generated method stub
		if (p != null)
			this.remove(p);

		p = new MyPanel(x, y);
		// new Timer().stop();

		this.add(p, BorderLayout.CENTER);
	}

}
