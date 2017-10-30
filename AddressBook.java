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

	public String toString() {
		StringBuilder s = new StringBuilder();
		for(BuddyInfo b: info) {
			s.append(b.toString());
			s.append("\n");
		}
		return s.toString();
	}

	public static void main(String[] args) {

		System.out.println("Address Book");

		BuddyInfo buddy = new BuddyInfo("Ryan", "aaa", "613115261");

		AddressBook addressbook = new AddressBook();

		addressbook.addBuddy(buddy);

		addressbook.removeBuddy(buddy);
		
		

	}

}