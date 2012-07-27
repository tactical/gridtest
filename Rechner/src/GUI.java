import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame{
	public GUI() {	
		
		//Fenster-Objekt
		final JFrame window = new JFrame();
		//Titel des Fensters
		window.setTitle("Rechner");
		//Größe des Fensters
		window.setSize(500,500);
		//Menü
		window.setMenuBar(this.getMenuBar());
		
		//Schließverhalten des Fensters
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new BorderLayout());
		
	    // Anfang Komponenten für das Eingabefeld
	    final JTextField eingabeFeld = new JTextField("Eingabe einer Zahl");
	    final JTable table = new JTable();
	    StringTableModel loModel = new StringTableModel();
	    table.setModel(loModel);
	    
	    eingabeFeld.setHorizontalAlignment(eingabeFeld.LEFT);

	    eingabeFeld.selectAll();
	    eingabeFeld.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!eingabeFeld.getText().equals("")) {
	    			StringTableModel loModel = (StringTableModel)table.getModel();
	    			loModel.addEingabe(eingabeFeld.getText());
	    			eingabeFeld.setText("");
	    		}
	    	}
	    });
	    //Füge Eingabefeld zum Frame hinzu
	   window.add(eingabeFeld, BorderLayout.NORTH);
	    
	    
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setLayout(new ScrollPaneLayout());
	    table.setFillsViewportHeight(true);
	    window.add(scrollPane, BorderLayout.CENTER);
    

	   //Darstellung des Fensters
	   window.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GUI gui = new GUI();
		
	}
	
	public MenuBar getMenuBar () {
		
		//Menü erstellen
		MenuBar menulist = new MenuBar();
		Menu datei = new Menu("Datei");
		
		//open
		MenuItem open = new MenuItem("Open");
		datei.add(open);
		
		//exit
		MenuItem exit = new MenuItem("Exit");
		datei.add(exit);
		
		//Actionlistener für exit
		exit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Die Anwendung wurde beendet");
					System.exit(0);
				}
		});
		menulist.add(datei);
		return menulist;
	}
	
	public class StringTableModel extends DefaultTableModel {
		private Vector<String> m_aStringLst = new Vector<>();

		public void addEingabe(String pcEingabe)
		{
			m_aStringLst.add(pcEingabe);
			fireTableRowsInserted(m_aStringLst.size()-1, m_aStringLst.size()-1);
		}
		
		public int getRowCount() 
		{
			if(m_aStringLst==null)
				return 0;
			return m_aStringLst.size();
		}
		
		public String getColumnName(int column) {
			return "Eingabe";
		}
		
		public int getColumnCount()
		{
			return 1;
		}
		
		public Object getValueAt(int pnRow, int pnColumn)
		{
			return m_aStringLst.elementAt(pnRow);
		}
	}
}
