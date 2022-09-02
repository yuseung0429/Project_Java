package database;

public class Staff {
	public Staff(String[] info)
	{
		this.id = info[0];
		this.password = info[1];
		this.name = info[2];
		this.sex = Boolean.parseBoolean(info[3]);
		this.phone = info[4];
		this.email = info[5];
		this.address = info[6];
		this.department = info[7];
		this.rank = info[8];
		this.level = Integer.parseInt(info[9]);
	}
	String id;
	String password;
	String name;
	boolean sex;
	String phone;
	String email;
	String address;
	String department;
	String rank;
	int level;
	
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append(id);
		str.append('\t');
		str.append(password);
		str.append('\t');
		str.append(name);
		str.append('\t');
		str.append(sex);
		str.append('\t');
		str.append(phone);
		str.append('\t');
		str.append(email);
		str.append('\t');
		str.append(address);
		str.append('\t');
		str.append(department);
		str.append('\t');
		str.append(rank);
		str.append('\t');
		str.append(level);
		return str.toString();
	}
	public String getId()
	{
		return id;
	}
	public String getPassword()
	{
		return password;
	}
	public String getName()
	{
		return name;
	}
	public boolean getSex()
	{
		return sex;
	}
	public String getPhone()
	{
		return phone;
	}
	public String getEmail()
	{
		return email;
	}
	public String getAddress()
	{
		return address;
	}
	public String getDepartment()
	{
		return department;
	}
	public String getRank()
	{
		return rank;
	}
	public int getLevel()
	{
		return level;
	}

}
