package second;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Winer extends JFrame implements ActionListener {
	JButton ok;
	JTextField txs;

	public Winer() {
		super("��Ӯ��");
		txs = new JTextField("��Ӯ��!!!    ��ʱ��" + String.valueOf(ChangePanel.times - 1) + " s");
		ok = new JButton("ȷ��");
		this.add(txs, BorderLayout.CENTER);
		this.add(ok, BorderLayout.SOUTH);
		this.setBounds(200, 200, 200, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
		ok.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == ok) {
			this.setVisible(false);;
		}

	}

}
