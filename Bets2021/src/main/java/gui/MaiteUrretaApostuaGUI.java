package gui;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;

public class MaiteUrretaApostuaGUI extends JFrame {
	private JTable table;
	public MaiteUrretaApostuaGUI() {
		
		 String[] columns = new String[] {
		            "Event", "Question", "Event Date", "Bet (€)"
		        };
		         
		
		 Object[][] data = new Object[][] {
	            {1, "John", 40.0, false },
	            {2, "Rambo", 70.0, false },
	            {3, "Zorro", 60.0, true },
	        };
		table = new JTable(data, columns);
		
         
	        this.setTitle("Table Example");
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
	        this.pack();
	        this.setVisible(true);
		getContentPane().add(table, BorderLayout.CENTER);
	}

}
