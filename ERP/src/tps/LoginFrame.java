package tps;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.DBMS;
import database.Data_Staff;
import database.Staff;

public class LoginFrame extends JFrame implements ActionListener{
	Container pane = getContentPane();
	JTextField id;
	JPasswordField password;
	LoginFrame()
	{
		setTitle("Login");
		getRootPane().setPreferredSize(new Dimension(800,200));
		pack();
		addWindowListener(new WindowExit());
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		setVisible(true);
		pane.setBackground(Color.white);
		
		Image logoimage = (new ImageIcon("logo.png")).getImage();
		setIconImage(logoimage);
		logoimage = logoimage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon logoicon = new ImageIcon(logoimage);
		JLabel logo = new JLabel(logoicon);
		logo.setBounds(100,50,50,50);
		pane.add(logo);
		
		JLabel title = new JLabel("FASTEST");
		title.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		title.setForeground(Color.black);
		title.setBounds(170,50,300,50);
		pane.add(title);
		
		JLabel semi_title = new JLabel("Enterprise Resource Planning System");
		semi_title.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		semi_title.setForeground(Color.black);
		semi_title.setBounds(50,110,280,25);
		semi_title.setHorizontalAlignment(JLabel.CENTER);
		pane.add(semi_title);
		
		JPanel login = new JPanel();
		login.setBounds(400,0,400,250);
		login.setBackground(Color.black);
		pane.add(login);
		
		JLabel id_title = new JLabel("ID");
		id_title.setBounds(20,10,100,25);
		id_title.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		id_title.setForeground(Color.white);
		login.add(id_title);
		
		id = new JTextField();
		id.setBounds(20,40,200,35);
		id.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		login.add(id);
		
		JLabel password_title = new JLabel("PASSWORD");
		password_title.setBounds(20,80,100,25);
		password_title.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		password_title.setForeground(Color.white);
		login.add(password_title);
		
		password = new JPasswordField();
		password.setBounds(20,110,200,35);
		password.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		login.add(password);
		
		JButton signin = new JButton("Signin");
		signin.setBounds(250,25,125,50);
		signin.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		signin.setBackground(Color.black);
		signin.setForeground(Color.white);
		signin.setActionCommand("signin");
		signin.addActionListener(this);
		login.add(signin);
		
		JButton signup = new JButton("Signup");
		signup.setBounds(250,95,125,50);
		signup.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.setActionCommand("signup");
		signup.addActionListener(this);
		login.add(signup);
		
		JButton find = new JButton("Did you forget your ID or password?");
		find.setBounds(150,155,230,25);
		find.setBackground(Color.black);
		find.setForeground(Color.white);
		find.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		find.setBorderPainted(false);
		find.setContentAreaFilled(false);
		find.setActionCommand("find");
		find.addActionListener(this);
		login.add(find);
		repaint();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "signup")
		{
			new SignupFrame();
		}
		else if(e.getActionCommand() == "signin")
		{
			Main.dbms.setDataType(DBMS.STAFF);
			Data_Staff data = (Data_Staff)Main.dbms.data;
			Staff user = data.getStaff(id.getText());
			if(user == null || !(user.getPassword()).equals((new ProtectPassword(password.getText())).getProtectPassword()))
				new Message("아이디 또는 비밀번호가 일치하지 않습니다.");
			else
			{
				if(user.getLevel() == 0)
					new Message("가입 승인 대기중입니다.");
				else
				{
					new MainFrame(user);
					dispose();
				}	
			}
		}
		else if(e.getActionCommand() == "find")
		{
			new IDPasswordFindFrame();
		}
	}
}
