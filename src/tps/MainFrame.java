package tps;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import database.Staff;

public class MainFrame extends JFrame{
	Container pane = getContentPane();
	Staff user;
	public MainFrame(Staff user)
	{
		this.user = user;
		setTitle("Fastest :: Enterprise Resource Planning System");
		getRootPane().setPreferredSize(new Dimension(1280,768));
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		pane.setBackground(Color.white);
		
		Image logoimage = (new ImageIcon("logo.png")).getImage();
		setIconImage(logoimage);
		logoimage = logoimage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon logoicon = new ImageIcon(logoimage);
		JLabel logo = new JLabel(logoicon);
		logo.setBounds(20,20,50,50);
		pane.add(logo);
		
		
		
		setVisible(true);
		
		
	}
}
