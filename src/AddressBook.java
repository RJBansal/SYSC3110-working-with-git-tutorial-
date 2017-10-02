import java.util.*;

class AddressBook {
	private Map<String, String> info = new HashMap<String, String>();
	
	public AddressBook()
	{
		
	}
	
	public void addBuddy(BuddyInfo buddy)
	{
		this.info.put(buddy.getName(), buddy.getAddress());
	}
	
	public void removeBuddy(BuddyInfo buddy)
	{
		this.info.remove(buddy.getName());
	}
	
	public static void main(String[] args) {
		System.out.println("Address Book");
		BuddyInfo buddy = new BuddyInfo("Ryan", "aaa", "613115261");
		AddressBook addressbook = new AddressBook();
		addressbook.addBuddy(buddy);
		addressbook.removeBuddy(buddy);
	}
}
