package database;

public class DBMS {
	public static final int STAFF = 0;
	public static final int SIZE = 1;
	public Data data;
	Data staff;
	public DBMS()
	{
		staff = new Data_Staff();
	}
	public boolean setDataType(int type)
	{
		switch(type)
		{
			case 0:	data = staff; return true;
			
		}
		return false;
	}
	public String getDataType()
	{
		return data.getClass().toString();
	}
	public boolean save()
	{
		for(int i = 0; i<SIZE; i++)
		{
			setDataType(i);
			if(data.dirty == true)
			{
				if(data.save()==false)
				{
					System.err.println(data.getClass().toString() + " save error");
					return false;
				}
			}
		}
		return true;
	}
	public void close()
	{
		if(save()==true)
			System.exit(1);
	}

	
}
