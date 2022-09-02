package tps;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import database.*;

public class SignupFrame extends JFrame implements Regex, ItemListener, ActionListener{
	Container pane;
	JTextField email_domain;
	JComboBox<String> email_list;
	JTextField id;
	JPasswordField password;
	JTextField name;
	JTextField phone_front;
	JTextField phone_middle;
	JTextField phone_back;
	JTextField email_id;
	JTextField address;
	JRadioButton male;
	JRadioButton female;
	SignupFrame()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
		setTitle("Sing up");
		pane = getContentPane();
		setSize(400,600);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pane.setBackground(Color.white);
		
		Image logoimage = (new ImageIcon("logo.png")).getImage();
		setIconImage(logoimage);
		logoimage = logoimage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon logoicon = new ImageIcon(logoimage);
		JLabel logo = new JLabel(logoicon);
		logo.setBounds(60,25,50,50);
		pane.add(logo);
		
		JLabel title = new JLabel("LYS Company");
		title.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		title.setForeground(Color.black);
		title.setBounds(125,25,300,50);
		pane.add(title);
		
		JLabel id_title = new JLabel("ID");
		id_title.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		id_title.setBounds(30,100,100,25);
		id_title.setHorizontalAlignment(JLabel.CENTER);
		pane.add(id_title);
		
		id = new JTextField();
		id.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		id.setBounds(150,100,200,25);
		id.setHorizontalAlignment(JTextField.CENTER);
		pane.add(id);
		
		JLabel password_title = new JLabel("Password");
		password_title.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		password_title.setBounds(30,150,100,25);
		password_title.setHorizontalAlignment(JLabel.CENTER);
		pane.add(password_title);
		
		password = new JPasswordField();
		password.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		password.setBounds(150,150,200,25);
		password.setHorizontalAlignment(JPasswordField.CENTER);
		pane.add(password);
		
		JLabel name_title = new JLabel("Name");
		name_title.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		name_title.setBounds(30,200,100,25);
		name_title.setHorizontalAlignment(JLabel.CENTER);
		pane.add(name_title);
		
		name = new JTextField();
		name.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		name.setBounds(150,200,200,25);
		name.setHorizontalAlignment(JTextField.CENTER);
		pane.add(name);
		
		JLabel phone_title = new JLabel("Phone");
		phone_title.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		phone_title.setBounds(30,250,100,25);
		phone_title.setHorizontalAlignment(JLabel.CENTER);
		pane.add(phone_title);
		
		phone_front = new JTextField();
		phone_front.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		phone_front.setBounds(150,250,50,25);
		phone_front.setHorizontalAlignment(JLabel.CENTER);
		pane.add(phone_front);
		
		JLabel bar1 = new JLabel("-");
		bar1.setBounds(200,250,15,25);
		bar1.setHorizontalAlignment(JLabel.CENTER);
		pane.add(bar1);
		
		phone_middle = new JTextField();
		phone_middle.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		phone_middle.setBounds(215,250,60,25);
		phone_middle.setHorizontalAlignment(JLabel.CENTER);
		pane.add(phone_middle);
		
		JLabel bar2 = new JLabel("-");
		bar2.setBounds(275,250,15,25);
		bar2.setHorizontalAlignment(JLabel.CENTER);
		pane.add(bar2);
		
		phone_back = new JTextField();
		phone_back.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		phone_back.setBounds(290,250,60,25);
		phone_back.setHorizontalAlignment(JLabel.CENTER);
		pane.add(phone_back);
		
		JLabel email_title = new JLabel("Email");
		email_title.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		email_title.setBounds(30,300,100,25);
		email_title.setHorizontalAlignment(JLabel.CENTER);
		pane.add(email_title);
		
		email_id = new JTextField();
		email_id.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		email_id.setBounds(30,330,100,25);
		pane.add(email_id);
		
		JLabel at = new JLabel("@");
		at.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		at.setBounds(130,330,20,25);
		at.setHorizontalAlignment(JLabel.CENTER);
		pane.add(at);
		
		String[] list = new String[6];
		list[0] = "naver.com";
		list[1] = "daum.net";
		list[2] = "hanmail.net";
		list[3] = "kakao.com";
		list[4] = "gmail.com";
		list[5] = "직접 입력";
		
		email_list = new JComboBox<String>(list);
		email_list.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		email_list.setBounds(150,330,100,25);
		email_list.setBackground(Color.white);
		email_list.setForeground(Color.black);
		email_list.addItemListener(this);
		pane.add(email_list);
		
		email_domain = new JTextField();
		email_domain.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		email_domain.setBounds(260,330,90,25);
		email_domain.setBackground(Color.white);
		email_domain.setEditable(false);
		email_domain.setText((String)email_list.getSelectedItem());
		pane.add(email_domain);
		
		JLabel address_title = new JLabel("Address");
		address_title.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		address_title.setBounds(30,380,100,25);
		address_title.setHorizontalAlignment(JLabel.CENTER);
		pane.add(address_title);
		
		address = new JTextField();
		address.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		address.setBounds(30,410,320,25);
		pane.add(address);
		
		JLabel sex_title = new JLabel("Sex");
		sex_title.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		sex_title.setBounds(30,460,100,25);
		sex_title.setHorizontalAlignment(JLabel.CENTER);
		pane.add(sex_title);
		
		ButtonGroup sex = new ButtonGroup();
		
		male = new JRadioButton("male");
		male.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		male.setBounds(150,460,100,25);
		male.setBackground(Color.white);
		male.setSelected(true);
		sex.add(male);
		pane.add(male);
		
		female = new JRadioButton("female");
		female.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		female.setBounds(250,460,100,25);
		female.setBackground(Color.white);
		sex.add(female);
		pane.add(female);
		
		JButton enter = new JButton("Sign up");
		enter.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		enter.setForeground(Color.white);
		enter.setBackground(Color.black);
		enter.setBounds(30,510,320,35);
		enter.setActionCommand("enter");
		enter.addActionListener(this);
		pane.add(enter);
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == 1)
		{
			if(e.getItem().equals("직접 입력"))
			{
				email_domain.setText("");
				email_domain.setEditable(true);
			}
			else
			{
				email_domain.setEditable(false);
				email_domain.setText((String)email_list.getSelectedItem());
			}
		}

	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "enter")
		{
			String[] temp = new String[Data_Staff.SIZE];
			temp[Data_Staff.ID] = id.getText();
			temp[Data_Staff.PASSWORD] = password.getText();
			temp[Data_Staff.NAME] = name.getText();
			temp[Data_Staff.PHONE] = phone_front.getText() + phone_middle.getText() + phone_back.getText();
			temp[Data_Staff.EMAIL] = email_id.getText() + "@" + email_domain.getText();
			temp[Data_Staff.ADDRESS] = address.getText();
			temp[Data_Staff.SEX] = male.isSelected() ? "0" : "1";
			temp[Data_Staff.DEPARTMENT] = "";
			temp[Data_Staff.RANK] = "";
			temp[Data_Staff.LEVEL] = "0";
			Main.dbms.setDataType(DBMS.STAFF);
			Data_Staff data = (Data_Staff)Main.dbms.data;
			if(temp[0].matches(ID) == false)
				new Message("ID는 영문자 또는 숫자로 구성된 6~12글자 입니다.");
			else if(data.existsStaffID(temp[Data_Staff.ID]) == true)
				new Message("이미 존재하는 ID입니다.");
			else if(temp[Data_Staff.PASSWORD].matches(PASSWORD) == false)
				new Message("비밀번호는 영문자, 숫자와 특수문자로 구성된 8~16글자 입니다");
			else if(temp[Data_Staff.NAME].matches(NAME) == false)
				new Message("유효하지 않은 이름입니다.");
			else if(temp[Data_Staff.PHONE].matches(PHONE) == false)
				new Message("유효하지 않은 번호입니다.");
			else if(data.existsStaffPhone(temp[Data_Staff.PHONE]) == true)
				new Message("이미 존재하는 휴대폰 번호입니다.");
			else if(temp[Data_Staff.EMAIL].matches(EMAIL) == false)
				new Message("유효하지 않은 이메일입니다.");
			else if(data.existsStaffEmail(temp[Data_Staff.EMAIL]) == true)
				new Message("이미 존재하는 이메일입니다.");
			else if(temp[Data_Staff.ADDRESS].equals("") == true)
				new Message("주소를 입력하세요.");
			else
			{
				new Message("회원가입이 완료되었습니다.");
				temp[Data_Staff.PASSWORD] = new ProtectPassword(temp[Data_Staff.PASSWORD]).getProtectPassword();
				data.addStaff(temp);
				dispose();
			}
		}	
	}
}
