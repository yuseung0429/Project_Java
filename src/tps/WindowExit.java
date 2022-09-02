package tps;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowExit extends WindowAdapter{
	public void windowClosing(WindowEvent e)
	{
		if(Main.dbms.save() == true)
			System.exit(0);
	}

}
