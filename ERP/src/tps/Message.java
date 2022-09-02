package tps;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Message extends JFrame implements ActionListener{
	Message(String arg)
	{
		Container pane = getContentPane();
		setSize(300,200);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle("알림");
		pane.setBackground(Color.white);
		
		JLabel info = new JLabel(arg);
		info.setHorizontalAlignment(JLabel.CENTER);
		info.setBounds(0,25,300,50);
		info.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		pane.add(info);
		
		JButton enter = new JButton("확인");
		enter.setBounds(120,100,60,30);
		enter.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		enter.setActionCommand("enter");
		enter.addActionListener(this);
		pane.add(enter);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "enter")
		{
			dispose();
		}
	}
	

}
