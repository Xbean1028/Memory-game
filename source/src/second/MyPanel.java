package second;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class MyPanel extends JPanel implements ActionListener {
	private int x, y;
	JButton b[];// 按钮
	int save[];// 生成的图标
	int flag = 0;
	int buffer = -1;
	int list[] = { -1, -1, -1, -1, -1, -1, -1 };// 缓存出现的图标位置
	int timeflag = 1;// 时间线程标记
	Timers timers=null;
	String picture[] = { "pic/a0.jpg", "pic/a1.jpg", "pic/a2.jpg", "pic/a3.jpg", "pic/a4.jpg", "pic/a5.jpg",
			"pic/a6.jpg" };

	public MyPanel(int x, int y) {
		setLayout(new GridLayout(x, y));
		setVisible(true);
		this.x = x;
		this.y = y;
		b = new JButton[x * y];
		save = new int[x * y];
		for (int i = 0; i < x * y; i++) {
			b[i] = new JButton();
			b[i].addActionListener(this);
			save[i] = new Random().nextInt(7);
			this.add(b[i]);
		}
		ChangePanel.look1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (timeflag == 1) {
			timers = new Timers();
			timers.start();
			timeflag = 0;
		}
		if (e.getSource() == ChangePanel.look1) {
			for (int i = 0; i < x * y; i++) {
				b[i].setIcon(new ImageIcon(picture[save[i]]));
			}
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
			    public void run() {
			    	for (int i = 0; i < x * y; i++) {
			    			b[i].setIcon(new ImageIcon());
					}
			    	int j=0;
			    	while (list[j]>-1){
			    		b[list[j]].setIcon(new ImageIcon(picture[save[list[j]]]));
			    		j++;
			    	}
			    }
			}, 2000);

		}
		for (int i = 0; i < x * y; i++) {
			if (e.getSource() == b[i]) {
				if (flag == 0) {
					b[i].setIcon(new ImageIcon(picture[save[i]]));
					list[flag] = i;
					flag++;
					buffer = save[i];
				} else {
					b[i].setIcon(new ImageIcon(picture[save[i]]));
					for (int j = flag - 1; j >= 0; j--) { // 判断重复按
						if (list[j] == i) {
							flag--;
						}
					}
					if (save[i] == buffer) {
						list[flag] = i;
						flag++;
						if (flag == x) {
							System.out.println("you are winner");
							// Timer().finish();
							new Winer();
							this.setVisible(false);
							timers.stop();
						}
					} else {
						for (int j = flag - 1; j >= 0; j--) {

							b[list[j]].setIcon(new ImageIcon());
							list[j] = -1;
						}
						flag = 0;
						list[flag] = i;
						flag++;
						buffer = save[i];
					}
				}

			}

		}
	}

	class Timers extends Thread {
		public void run() {
			while (true) {
				ChangePanel.times++;
				
				ChangePanel.tx
						.setText("时间: " + String.valueOf(ChangePanel.times) + " s，找出 " + String.valueOf(x) + " 个相同图标");
				try {
					Thread.sleep(1000);
				} catch (Exception ex) {
				}
			}
		}


	}

}
