package tps;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.time.LocalDate;
public class Calendar extends JFrame implements ActionListener, ItemListener{
	Container pane = getContentPane();
	JComboBox<Integer> years;
	JComboBox<Integer> months;
	Integer[] int_years;
	JButton[] days;
	JButton before;
	JButton current;
	String select_date;
	int[] MonthlyDays = {31,28,31,30,31,30,31,31,30,31,30,31};
	Calendar()
	{
		setSize(405,450);
		setTitle("Calendar");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		pane.setBackground(Color.white);
		
		int_years = new Integer[100];
		for(int i=0; i<int_years.length; i++)
			int_years[i] = 1950+i;
		years = new JComboBox<Integer>(int_years);
		years.setBounds(5,15,105,25);
		years.setBackground(Color.white);
		years.setSelectedItem(LocalDate.now().getYear());
		years.addItemListener(this);
		pane.add(years);
		
		Integer[] int_months = new Integer[12];
		for(int i=0; i<int_months.length; i++)
			int_months[i] = i+1;
		months = new JComboBox<Integer>(int_months);
		months.setBounds(115,15,50,25);
		months.setBackground(Color.white);
		months.setSelectedItem(LocalDate.now().getMonthValue());
		months.addItemListener(this);
		pane.add(months);
		
		JButton back = new JButton("◀");
		back.setBounds(170,15,50,25);
		back.setBackground(Color.white);
		back.setFocusPainted(false);
		back.setActionCommand("back");
		back.addActionListener(this);
		pane.add(back);
		
		JButton next = new JButton("▶");
		next.setBounds(225,15,50,25);
		next.setBackground(Color.white);
		next.setFocusPainted(false);
		next.setActionCommand("next");
		next.addActionListener(this);
		pane.add(next);
		
		JButton enter = new JButton("확인");
		enter.setBounds(280,15,105,25);
		enter.setBackground(Color.white);
		enter.setFocusPainted(false);
		enter.setActionCommand("enter");
		enter.addActionListener(this);
		pane.add(enter);
		
		String[] str_days= {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		JLabel[] days_title = new JLabel[7];
		for(int i=0; i<days_title.length; i++)
		{
			days_title[i] = new JLabel(str_days[i]);
			days_title[i].setBounds(5+(i*55),50,50,25);
			days_title[i].setHorizontalAlignment(JLabel.CENTER);
			if(i==0)
				days_title[i].setForeground(Color.red);
			else if(i==6)
				days_title[i].setForeground(Color.blue);
			pane.add(days_title[i]);
		}
		days = new JButton[42];
		for(int i=0; i<days.length; i++)
		{
			days[i] = new JButton(String.valueOf(i));
			days[i].setBounds(5+((i%7)*55), 80+((i/7)*55),50,50);
			days[i].setBackground(Color.white);
			days[i].setBorderPainted(true);
			days[i].setFocusPainted(false);
			days[i].setFont(new Font("맑은고딕",Font.BOLD,15));
			days[i].setActionCommand("day");
			days[i].addActionListener(this);
			if(i%7 == 0)
				days[i].setForeground(Color.red);
			else if(i%7 == 6)
				days[i].setForeground(Color.blue);
			pane.add(days[i]);
		}
		setCalendar(LocalDate.now().getYear(),LocalDate.now().getMonthValue());
		revalidate();
		repaint();
	}
	public void actionPerformed(ActionEvent e) {
		String select = e.getActionCommand();
		if(select.equals("enter"))
		{
			if(current != null)
			{
				select_date = new StringBuilder(years.getSelectedItem().toString()).append("-").append(months.getSelectedIndex()+1).append("-").append(current.getText()).toString();
				MainFrame2.date.setText(this.getSelectedDate());
				dispose();
			}
		}
		else if(select.equals("day"))
		{
			if(before!=null)
				before.setBackground(Color.white); 
			current = (JButton)e.getSource();
			current.setBackground(Color.gray);
			before = current;
		}
		else if(select.equals("back"))
		{
			if(before!=null)
				before.setBackground(Color.white); 
			if(months.getSelectedIndex()==0)
			{
				if(years.getSelectedIndex() != 0)
				{
					years.setSelectedIndex(years.getSelectedIndex()-1);
					months.setSelectedIndex(11);
				}
				else
					return;
			}
			else
				months.setSelectedIndex(months.getSelectedIndex()-1);
			setCalendar((int) years.getSelectedItem(), months.getSelectedIndex()+1);
			pane.repaint();
		}
		else if(select.equals("next"))
		{
			if(before!=null)
				before.setBackground(Color.white); 
			if(months.getSelectedIndex()==11)
			{
				if(years.getSelectedIndex() != int_years.length-1)
				{
					years.setSelectedIndex(years.getSelectedIndex()+1);
					months.setSelectedIndex(0);
				}
				else
					return;
			}
			else
				months.setSelectedIndex(months.getSelectedIndex()+1);
			setCalendar((int) years.getSelectedItem(), months.getSelectedIndex()+1);
			pane.repaint();
		}
	}
	public void setCalendar(int year, int month)
	{
		int firstday = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
		if(firstday == 7)
			firstday = 0;
		int numday = getNumDay(year,month); 
		for(int i=0; i<days.length;)
		{
			if(i<firstday || i>= firstday+numday)
				pane.remove(days[i++]);
			else
			{
				for(int j=0; j<numday; )
				{
					days[i].setText(String.valueOf(++j));
					pane.add(days[i++]);
				}
			}
		}
	}
	private int getNumDay(int year, int month)
	{
		if(month == 2)
		{
			if(isLeafYear(year)==true)
				MonthlyDays[1]=29;
			else
				MonthlyDays[1]=28;
		}
		return MonthlyDays[month-1];
	}
	private boolean isLeafYear(int year)
	{
		if(year%400 == 0 || (year%100 != 0 && year % 4 == 0))
			return true;
		return false;
	}
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == 1)
			setCalendar((int) years.getSelectedItem(), months.getSelectedIndex()+1);
	}
	public String getSelectedDate()
	{
		return select_date==null ? null : select_date;
	}
}
