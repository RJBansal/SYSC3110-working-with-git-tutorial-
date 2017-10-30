import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class AddresBookFrame extends JFrame implements ActionListener{

	JFrame f;
	JTextArea text;
	JPanel cp;
	JMenuBar menuBar;
	JMenu Addressmenu, BuddyMenu; 
	JMenuItem item1, item2, item3, item4;
	AddressBook ab;
	
	public AddresBookFrame() {
		f = new JFrame("Address Book");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400,400);
		cp = new JPanel(); 
		cp.setLayout(new BorderLayout());
		text = new JTextArea();
		f.add(cp);
		f.setLocationRelativeTo(null);
		
		f.getContentPane().add(text);
		
		
		menuBar = new JMenuBar( );
	    setJMenuBar( menuBar );
	    
	    Addressmenu = new JMenu( "AddressBook" );
	    menuBar.add( Addressmenu );
	    BuddyMenu = new JMenu( "BuddyInfo" );
	    menuBar.add( BuddyMenu );
	  
	    item1 = new JMenuItem("Create");
	    item1.addActionListener(this);
	    item2 = new JMenuItem("Save");
	    item2.addActionListener(this);
	    item2.setEnabled(false);
	    item3 = new JMenuItem("Display");
	    item3.addActionListener(this);
	    item3.setEnabled(false);


	    Addressmenu.add(item1);
	    Addressmenu.add(item2);
	    Addressmenu.add(item3);
	    
	    item4 = new JMenuItem("Add Menu Item");
	    item4.addActionListener(this);
	    item4.setEnabled(false);
	    BuddyMenu.add(item4);
	    
	    f.setJMenuBar(menuBar);
	    
	    
	    f.setVisible(true);
	}
	    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == item1) {
        	ab = new AddressBook();
        	item2.setEnabled(true);
        	item3.setEnabled(true);
        	item4.setEnabled(true);
        	JOptionPane.showMessageDialog(f,"AddressBook Created");
        }
        else if(e.getSource() == item2) {
        	BufferedWriter out = null;
			try {
				out = new BufferedWriter(new FileWriter("myFile.txt"));
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
        	try {
				out.write(ab.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
        	try {
				out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        }
        else if(e.getSource() == item3) {
        	text.setText(ab.toString());
        }
        else if(e.getSource() == item4) {
        	getBuddyInfo();
        }
    }
	
    public void getBuddyInfo() {
    	String name= JOptionPane.showInputDialog("Please input name for buddy: ");

        String address = JOptionPane.showInputDialog("Please input address for buddy: ");

        String number = JOptionPane.showInputDialog("Please input number for buddy: ");
        BuddyInfo b = new BuddyInfo(name, address, number); 
        ab.addBuddy(b);
        text.setText(b.toString());
    }
	    
	public static void main(String[] args) {
		AddresBookFrame n = new AddresBookFrame();

	}

}
