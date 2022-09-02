package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Data_Staff extends Data {
	public static final int ID = 0;
	public static final int PASSWORD = 1;
	public static final int NAME = 2;
	public static final int SEX = 3;
	public static final int PHONE = 4;
	public static final int EMAIL = 5;
	public static final int ADDRESS = 6;
	public static final int DEPARTMENT = 7;
	public static final int RANK = 8;
	public static final int LEVEL = 9;
	public static final int SIZE = 10;
	HashMap<String, Staff> staffs;
	HashSet<String> staffs_phone;
	HashSet<String> staffs_email;
	HashMap<String, Staff> ready_staffs;

	Data_Staff() {
		staffs = new HashMap<String, Staff>();
		staffs_phone = new HashSet<String>();
		staffs_email = new HashSet<String>();
		ready_staffs = new HashMap<String, Staff>();
		try {
			File staffs_file = new File("staff.txt");
			if (staffs_file.exists() == false)
				staffs_file.createNewFile();
			BufferedReader br = new BufferedReader(new FileReader(staffs_file));
			String temp;
			while ((temp = br.readLine()) != null) {
				String[] info = temp.split("\t");
				addStaff(info);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Staff getStaff(String id) {
		Staff temp = staffs.get(id);
		return (temp!=null)? temp : ready_staffs.get(id);
	}

	public void addStaff(String[] info) {
		if (info[LEVEL].equals("0") == true)
			ready_staffs.put(info[ID], new Staff(info));
		else
			staffs.put(info[ID], new Staff(info));
		staffs_phone.add(info[PHONE]);
		staffs_email.add(info[EMAIL]);
		this.dirty = true;
	}

	public boolean existsStaffID(String id) {
		return staffs.containsKey(id);
	}

	public boolean existsStaffPhone(String number) {
		return staffs_phone.contains(number);
	}

	public boolean existsStaffEmail(String email) {
		return staffs_email.contains(email);
	}

	boolean save() {
		ArrayList<String> keyStaffs = new ArrayList<String>();
		keyStaffs.addAll(staffs.keySet());
		keyStaffs.addAll(ready_staffs.keySet());
		Collections.sort(keyStaffs);
		try {
			File temp = new File("temp.txt");
			if (temp.exists() == false)
				temp.createNewFile();
			BufferedWriter br = new BufferedWriter(new FileWriter(temp));
			for (String key : keyStaffs) {
				br.write(getStaff(key).toString());
			}
			br.close();
			File target = new File("staff.txt");
			target.delete();
			temp.renameTo(target);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
