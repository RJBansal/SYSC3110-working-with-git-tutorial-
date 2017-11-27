import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AddresBookFrame extends JFrame implements ActionListener, ListSelectionListener{

	JFrame f;
	JTextArea text;
	BuddyInfo selected; 
	JPanel cp;
	JMenuBar menuBar;
	JMenu Addressmenu, BuddyMenu, infomenu; 
	JMenuItem item1, item2, item3, item4, item5, item6, importFile;
	AddressBook ab;
	
	DefaultListModel<BuddyInfo> buddymodel;
	JList<BuddyInfo> buddylist; 
	
	public AddresBookFrame() {
		
		buddymodel = new DefaultListModel<>();
		buddylist = new JList<>(buddymodel);
		buddylist.addListSelectionListener(this);
		buddylist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		f = new JFrame("Address Book");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400,400);
		cp = new JPanel(); 
		cp.setLayout(new BorderLayout());
		f.add(cp);
		f.setLocationRelativeTo(null);
		
		f.add(new JScrollPane(buddylist));
		
		
		menuBar = new JMenuBar( );
	    setJMenuBar( menuBar );
	    
	    Addressmenu = new JMenu( "AddressBook" );
	    menuBar.add( Addressmenu );
	    BuddyMenu = new JMenu( "BuddyInfo" );
	    menuBar.add( BuddyMenu );
	    infomenu = new JMenu("Edit/Remove");
	    menuBar.add(infomenu);
	  
	    item1 = new JMenuItem("Create");
	    item1.addActionListener(this);
	    item2 = new JMenuItem("Save");
	    item2.addActionListener(this);
	    item2.setEnabled(false);
	    importFile = new JMenuItem("Import");
	    importFile.addActionListener(this);
	   // importFile.setEnabled(false);
	    item3 = new JMenuItem("Display");
	    item3.addActionListener(this);
	    item3.setEnabled(false);


	    Addressmenu.add(item1);
	    Addressmenu.add(item2);
	    Addressmenu.add(item3);
	    Addressmenu.add(importFile);
	    
	    item4 = new JMenuItem("Add Menu Item");
	    item4.addActionListener(this);
	    item4.setEnabled(false);
	    BuddyMenu.add(item4);
	    
	    item5 = new JMenuItem("Edit Address");
	    item6 = new JMenuItem("Remove");
	    item5.addActionListener(this);
	    item6.addActionListener(this);
	    item5.setEnabled(false);
	    item6.setEnabled(false);
	    infomenu.add(item5);
	    infomenu.add(item6);
	    
	    f.setJMenuBar(menuBar);
	    
	    
	    f.setVisible(true);
	}
	    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == item1) {
        	ab = new AddressBook();
        	item2.setEnabled(true);
        	item3.setEnabled(true);
        	item4.setEnabled(true);
        	importFile.setEnabled(true);
        	JOptionPane.showMessageDialog(f,"AddressBook Created");
        }
        else if(e.getSource() == item2) {
        	 ab.exportFile();
        }
        else if(e.getSource() == item3) {
        	
        }
        else if(e.getSource() == item4) {
        	getBuddyInfo();
        }
        else if(e.getSource() == item5) {
        	String address = JOptionPane.showInputDialog("Please enter new address for buddy: " + selected.getName());
        	selected.setAddress(address);
        	
        }
        else if(e.getSource() == item6) {
        	ab.removeBuddy(selected);
        	buddymodel.removeElement(selected);
        
        }
        else if(e.getSource() == importFile) {
        	 this.ab = ab.importFile();
        	 buddymodel.clear();
        	 buddymodel.addElement(ab.getBuddy(0));
        }
    }
    
    public void valueChanged(ListSelectionEvent e) {
    	selected = buddylist.getSelectedValue();
    	item5.setEnabled(true);
		item6.setEnabled(true);
    	
    	if(buddylist.isSelectionEmpty()) {
    		item5.setEnabled(false);
        	item6.setEnabled(false);
        	
    	}
    	
    	
    }
	
    public void getBuddyInfo() {
    	String name= JOptionPane.showInputDialog("Please input name for buddy: ");
        String address = JOptionPane.showInputDialog("Please input address for buddy: ");
        String number = JOptionPane.showInputDialog("Please input number for buddy: ");
        
        BuddyInfo b = new BuddyInfo(name, address, number); 
        ab.addBuddy(b);
        buddymodel.addElement(b);
        
    }
	    
	public static void main(String[] args) {
		AddresBookFrame n = new AddresBookFrame();

	}

}
