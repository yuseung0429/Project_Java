package tps;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import database.DBMS;
import database.Data_Staff;
import database.Staff;


public class IDPasswordFindFrame extends JFrame implements ActionListener{
	Container pane;
	JTextField name;
	JTextField phone_front;
	JTextField phone_middle;
	JTextField phone_back;
	JComboBox<String> email_list;
	JTextField email_id;
	JTextField email_domain;
	JRadioButton phone;
	JRadioButton email;
	JPanel emailpanel;
	JPanel phonepanel;
	JPanel infopanel;
	JButton idfind;
	JButton passwordfind;
	private JTextField id;
	private JLabel id_title;
	
	public IDPasswordFindFrame()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
		setTitle("Fining ID / Password");
		pane = getContentPane();
		getRootPane().setPreferredSize(new Dimension(400,400));
		pack();
		setVisible(true);
		setResizable(false);
		setLayout(null);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pane.setBackground(Color.white);

		idfind = new JButton("ID");
		idfind.setBounds(20,20,160,50);
		idfind.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		idfind.setBackground(Color.black);
		idfind.setForeground(Color.white);
		idfind.setActionCommand("idfind");
		idfind.addActionListener(this);
		idfind.setBorderPainted(false);
		idfind.setFocusPainted(false);
		pane.add(idfind);
		
		passwordfind = new JButton("Password");
		passwordfind.setBounds(220,20,160,50);
		passwordfind.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		passwordfind.setBackground(Color.black);
		passwordfind.setForeground(Color.white);
		passwordfind.setActionCommand("passwordfind");
		passwordfind.addActionListener(this);
		passwordfind.setBorderPainted(false);
		passwordfind.setFocusPainted(false);
		pane.add(passwordfind);
		
		infopanel = new JPanel();
		infopanel.setBounds(0,90,400,210);
		infopanel.setLayout(null);
		infopanel.setVisible(false);
		infopanel.setBackground(Color.white);
		pane.add(infopanel);
		
		JLabel name_title = new JLabel("NAME");
		name_title.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		name_title.setBounds(20,20,100,25);
		name_title.setHorizontalAlignment(JLabel.CENTER);
		infopanel.add(name_title);
		
		name = new JTextField();
		name.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		name.setBounds(150,20,200,25);
		name.setHorizontalAlignment(JTextField.CENTER);
		infopanel.add(name);

		JLabel authentication_title = new JLabel("Authentication");
		authentication_title.setBounds(20,70,130,25);
		authentication_title.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		authentication_title.setHorizontalAlignment(JLabel.CENTER);
		infopanel.add(authentication_title);
		
		ButtonGroup authentication = new ButtonGroup();
		
		phone = new JRadioButton("Phone");
		phone.setBounds(175, 70, 100, 30);
		phone.setActionCommand("phone");
		phone.addActionListener(this);
		phone.setBackground(Color.white);
		authentication.add(phone);
		infopanel.add(phone);
		
		email = new JRadioButton("Email");
		email.setBounds(275, 70, 100, 30);
		email.setActionCommand("email");
		email.addActionListener(this);
		email.setBackground(Color.white);
		authentication.add(email);
		infopanel.add(email);
		
		phonepanel = new JPanel();
		phonepanel.setBounds(0,100,400,100);
		phonepanel.setLayout(null);
		phonepanel.setVisible(false);
		phonepanel.setBackground(Color.white);
		infopanel.add(phonepanel);
		
		JLabel phone_title = new JLabel("Phone");
		phone_title.setBounds(20,20,100,25);
		phone_title.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		phone_title.setHorizontalAlignment(JLabel.CENTER);
		phonepanel.add(phone_title);
		
		phone_front = new JTextField();
		phone_front.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		phone_front.setBounds(150,20,50,25);
		phone_front.setHorizontalAlignment(JLabel.CENTER);
		phonepanel.add(phone_front);
		
		JLabel bar1 = new JLabel("-");
		bar1.setBounds(200,20,15,25);
		bar1.setHorizontalAlignment(JLabel.CENTER);
		phonepanel.add(bar1);
		
		phone_middle = new JTextField();
		phone_middle.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		phone_middle.setBounds(215,20,60,25);
		phone_middle.setHorizontalAlignment(JLabel.CENTER);
		phonepanel.add(phone_middle);
		
		JLabel bar2 = new JLabel("-");
		bar2.setBounds(275,20,15,25);
		bar2.setHorizontalAlignment(JLabel.CENTER);
		phonepanel.add(bar2);
		
		phone_back = new JTextField();
		phone_back.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		phone_back.setBounds(290,20,60,25);
		phone_back.setHorizontalAlignment(JLabel.CENTER);
		phonepanel.add(phone_back);
		
		emailpanel = new JPanel();
		emailpanel.setBounds(0,100,400,100);
		emailpanel.setLayout(null);
		emailpanel.setVisible(false);
		emailpanel.setBackground(Color.white);
		infopanel.add(emailpanel);
		
		JLabel email_title = new JLabel("Email");
		email_title.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		email_title.setBounds(20,20,100,25);
		email_title.setHorizontalAlignment(JLabel.CENTER);
		emailpanel.add(email_title);
		
		email_id = new JTextField();
		email_id.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		email_id.setBounds(30,60,100,25);
		emailpanel.add(email_id);
		
		JLabel at = new JLabel("@");
		at.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		at.setBounds(130,60,20,25);
		at.setHorizontalAlignment(JLabel.CENTER);
		emailpanel.add(at);
		
		String[] list = new String[6];
		list[0] = "naver.com";
		list[1] = "daum.net";
		list[2] = "hanmail.net";
		list[3] = "kakao.com";
		list[4] = "gmail.com";
		list[5] = "직접 입력";
		
		email_list = new JComboBox<String>(list);
		email_list.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		email_list.setBounds(150,60,100,25);
		email_list.setBackground(Color.white);
		email_list.setForeground(Color.black);
		emailpanel.add(email_list);
		
		email_domain = new JTextField();
		email_domain.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		email_domain.setBounds(260,60,90,25);
		email_domain.setBackground(Color.white);
		email_domain.setEditable(false);
		email_domain.setText((String)email_list.getSelectedItem());
		emailpanel.add(email_domain);
		
		id_title = new JLabel("ID");
		id_title.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		id_title.setBounds(20,90,100,25);
		id_title.setHorizontalAlignment(JLabel.CENTER);
		id_title.setVisible(false);
		pane.add(id_title);
		
		id = new JTextField();
		id.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		id.setBounds(150,90,200,25);
		id.setHorizontalAlignment(JTextField.CENTER);
		id.setVisible(false);
		pane.add(id);
		
		JButton enter = new JButton("Enter");
		enter.setBounds(20,330,360,50);
		enter.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		enter.setForeground(Color.white);
		enter.setBackground(Color.black);
		enter.addActionListener(this);
		enter.setActionCommand("enter");
		pane.add(enter);
		
		revalidate();
		repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "idfind")
		{
			id_title.setVisible(true);
			id.setVisible(false);
			infopanel.setBounds(0,90,400,210);
			infopanel.setVisible(true);
			idfind.setForeground(Color.orange);
			passwordfind.setForeground(Color.white);
		}
		else if (e.getActionCommand() == "passwordfind")
		{
			id_title.setVisible(true);
			id.setVisible(true);
			infopanel.setBounds(0,120,400,210);
			infopanel.setVisible(true);
			idfind.setForeground(Color.white);
			passwordfind.setForeground(Color.orange);
		}
		else if (e.getActionCommand() == "phone")
		{
			phonepanel.setVisible(true);
			emailpanel.setVisible(false);
		}
		else if (e.getActionCommand() == "email")
		{
			phonepanel.setVisible(false);
			emailpanel.setVisible(true);
		}
		else if (e.getActionCommand() == "enter")
		{
			String temp_id = id.getText();
			String temp_name = name.getText();
			String temp_email = (new StringBuilder(email_id.getText())).append("@").append(email_domain.getText()).toString();
			String temp_phone = (new StringBuilder(phone_front.getText())).append(phone_middle.getText()).append(phone_back.getText()).toString();
			if(idfind.getForeground().equals(Color.orange))
			{
				
			}
			else if(passwordfind.getForeground().equals(Color.orange))
			{
				Main.dbms.setDataType(DBMS.STAFF);
				Staff temp_staff = ((Data_Staff)Main.dbms.data).getStaff(temp_id);
				if(temp_staff != null && temp_name.equals(temp_staff.getName()) && (temp_email.equals(temp_staff.getEmail()) || temp_phone.equals(temp_staff.getPhone())))
					new PasswordChangeFrame(temp_staff);
				else
					new Message("일치하는 정보가 없습니다.");
			}
			else
			{
				new Message("아이디 찾기 또는 비밀번호 찾기를 누르세요.");
			}

		}
		
	}

}
