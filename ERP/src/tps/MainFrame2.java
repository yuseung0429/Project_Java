package tps;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class MainFrame2 extends JFrame implements ActionListener{
	Container pane = getContentPane();
	static JTextField date;
	JTable table;
	DefaultTableModel model;
	JLabel debit;
	JLabel credit;
	MainFrame2()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
		setTitle("Transaction processing system");
		setSize(1280,760);
		addWindowListener(new WindowExit());
		setLocationRelativeTo(null);
		setLayout(null);
		getRootPane().setPreferredSize(new Dimension(1280,768));
		pane.setBackground(Color.white);
		setVisible(true);
		
		date = new JTextField();
		date.setBounds(20,20,100,30);
		pane.add(date);
		
		JButton calendar = new JButton("달력");
		calendar.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		calendar.setBounds(130,20,60,30);
		calendar.setActionCommand("calendar");
		calendar.addActionListener(this);
		pane.add(calendar);
		
		JButton lookup = new JButton("조회");
		lookup.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		lookup.setBounds(200,20,60,30);
		lookup.setActionCommand("lookup");
		lookup.addActionListener(this);
		pane.add(lookup);
		
		JButton add = new JButton("추가");
		add.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		add.setBounds(270,20,60,30);
		add.setActionCommand("add");
		add.addActionListener(this);
		pane.add(add);
		
		JButton delete = new JButton("삭제");
		delete.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		delete.setBounds(340,20,60,30);
		delete.setActionCommand("delete");
		delete.addActionListener(this);
		pane.add(delete);
		
		JButton save = new JButton("저장");
		save.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		save.setBounds(410,20,60,30);
		save.setActionCommand("save");
		save.addActionListener(this);
		pane.add(save);
		
		String[] table_col_title = {"번호","일시","차변/대변", "분류", "세부분류", "거래처", "거래금", "비고"};
		model = new DefaultTableModel(table_col_title,0);
		table = new JTable(model);
		JScrollPane spane = new JScrollPane(table);
		spane.setBounds(20,70,1220,500);
		pane.add(spane);
		
		table.getColumn("번호").setPreferredWidth(40);
		table.getColumn("일시").setPreferredWidth(160);
		table.getColumn("차변/대변").setPreferredWidth(160);
		table.getColumn("분류").setPreferredWidth(160);
		table.getColumn("세부분류").setPreferredWidth(160);
		table.getColumn("거래처").setPreferredWidth(160);
		table.getColumn("거래금").setPreferredWidth(160);
		table.getColumn("비고").setPreferredWidth(220);
		
		JLabel debit_title = new JLabel("차변 총계 : ");
		debit_title.setBounds(20, 575, 100, 25);
		debit_title.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pane.add(debit_title);
		
		debit = new JLabel();
		debit.setBounds(120,575,100,25);
		debit.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pane.add(debit);
		
		JLabel credit_title = new JLabel("대변 총계 : ");
		credit_title.setBounds(20, 600, 100, 25);
		credit_title.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pane.add(credit_title);
		
		credit = new JLabel();
		credit.setBounds(120,600,100,25);
		credit.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pane.add(credit);
		
		pack();
		show();
		revalidate();
		repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "calendar")
		{
			Calendar cal= new Calendar();
		}
		else if(e.getActionCommand() == "lookup")
		{
			model.setNumRows(0);
			try {
				File target = new File(date.getText()+".txt");
				if (target.exists() == false)
					target.createNewFile();
				BufferedReader br = new BufferedReader(new FileReader(target));
				String temp;
				while((temp = br.readLine()) != null)
				{
					String[] temp_array = temp.split("\t");
					model.addRow(temp_array);
				}
				br.close();
				setDebitCreaditTotal();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand() == "add")
		{
			if(table.getSelectedRow() == -1)
				model.addRow(new String[8]);
			else
				model.insertRow(table.getSelectedRow()+1, new String[8]);
		}
		else if(e.getActionCommand() == "delete")
		{
			int[] rows = table.getSelectedRows();
			for(int i=rows.length-1; i>=0; i--)
				model.removeRow(rows[i]);
			setDebitCreaditTotal();
		}
		else if(e.getActionCommand() == "save")
		{
			if(debit.getText().equals(credit.getText())==false)
			{
				new Message("차변총계와 대변총계가 일치하지 않습니다.");
				
			}
			else
			{
				try {
					File temp = new File("temp.txt");
					temp.createNewFile();
					BufferedWriter br = new BufferedWriter(new FileWriter(temp));
					for (int i = 0; i < model.getRowCount(); i++) {
						for (int j = 0; j < model.getColumnCount(); j++) {
							if ((String) model.getValueAt(i, j) != null)
								br.write((String) model.getValueAt(i, j));
							if (j != model.getColumnCount() - 1)
								br.write('\t');
						}
						if (i != model.getRowCount() - 1)
							br.write('\n');
					}
					br.close();
					File target = new File(date.getText() + ".txt");
					target.delete();
					temp.renameTo(target);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	public void setDebitCreaditTotal()
	{
		long sum_debit=0;
		long sum_credit=0;
		for(int i=0; i<model.getRowCount(); i++)
		{
			if(model.getValueAt(i, 2).equals("차변"))
				sum_debit += Long.parseLong((String)model.getValueAt(i,6));
			else
				sum_credit += Long.parseLong((String)model.getValueAt(i,6));
		}
		debit.setText(String.valueOf(sum_debit));
		credit.setText(String.valueOf(sum_credit));
	}
}
