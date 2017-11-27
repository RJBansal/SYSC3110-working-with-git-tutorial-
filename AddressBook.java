import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.*;


class AddressBook {

	private ArrayList<BuddyInfo> info = new ArrayList<BuddyInfo>();

	

	public AddressBook()

	{

		

	}

	
	public void addBuddy(BuddyInfo buddy)

	{

		this.info.add(buddy);

	}

	

	public void removeBuddy(BuddyInfo buddy)

	{

		this.info.remove(buddy);

	}
	
	public BuddyInfo getBuddy(int index) {
		return info.get(index);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for(BuddyInfo b: info) {
			s.append(b.toString());
			s.append("\n");
		}
		return s.toString();
	}
	
	public void exportFile() {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("myFile.txt"));       	
			out.write(this.toString());
			out.close();
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static AddressBook importFile() {
		File file = new File("myFile.txt");
		AddressBook ab = new AddressBook();
		try {
			Scanner sc = new Scanner(file);
			String t = sc.nextLine();
			String[] split = t.split(" ");
			BuddyInfo b = new BuddyInfo(split[1], split[3], split[5]);
			ab.addBuddy(b);
			return ab;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error");
		}
		return ab;
	}

	public static void main(String[] args) {

		System.out.println("Address Book");

		BuddyInfo buddy = new BuddyInfo("Ryan", "aaa", "613115261");

		AddressBook addressbook = new AddressBook();

		addressbook.addBuddy(buddy);

		addressbook.removeBuddy(buddy);
		
		

	}

}