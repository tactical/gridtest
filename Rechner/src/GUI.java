import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.JFrame;

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
		
 
		//Container für das Eingabefeld
		final Container cEingabe = getContentPane();
		cEingabe.setLayout(new BorderLayout());
				
			
	    // Anfang Komponenten für das Eingabefeld
	    final JTextField eingabeFeld = new JTextField("Eingabe einer Zahl");
	    final JTable table = new JTable(10,1);
	    eingabeFeld.setHorizontalAlignment(eingabeFeld.LEFT);
	    cEingabe.add(eingabeFeld,BorderLayout.NORTH);
	    eingabeFeld.selectAll();
	    eingabeFeld.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(eingabeFeld.getText().equals("")) {
	    			
	    		} else {
	    			table.add(eingabeFeld.getText(), cEingabe);
	    			repaint();
	    			eingabeFeld.resetKeyboardActions();
	    			
	    		}
	    		
	    	 
	    	}
	    });
	    //Füge Eingabefeld zum Frame hinzu
	   window.add(cEingabe);
	    
	    
	    JScrollPane scrollPane = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	    window.add(scrollPane, BorderLayout.SOUTH);
	 
	    
	    
	    

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
	
	public void paint(Graphics gr) {
		
	}
}
