package de.uni_hannover.task2;
import de.uni_hannover.task2.auth.*;
import de.uni_hannover.task2.offerings.*;

public class Marketplace{
	public User[] Users;
	
	public Marketplace() {
		this.Users = new User[10];
	}
	
	public boolean addUser(User user_to_insert) {
		
		// überprüfen, ob Benutzername einzigartig
		for (User u: this.Users) {
			if (u == null) continue;
			if (u.getBenutzername() == user_to_insert.getBenutzername()) {
				System.out.println("User with name: |" + 
				user_to_insert.getBenutzername() + "| already exists");
				return false;
			}
		}
		
		int index = 0;
		for (User u: this.Users) {
			if (u == null) {
				this.Users[index] = user_to_insert;
				//u = user_to_insert;
				//System.out.println("added user: " + this.Users[index].getBenutzername());
				return true;
			}
			index++;
		}
		System.out.println("User limit reached!");
		return false;
	}
	
	public String str() {
		String str = "\n\nMARKETPLACE \n";
		for (User us: this.Users) {
			if (us != null) {
				str = str + "\nUser: " + us.getBenutzername() + "\n";
				//System.out.println("User found: " + us.getBenutzername());
				for (Item it: us.getItems()) {
					if (it != null) {
						str = str + "[Item: " + it.getName() + "; Preis: " + it.getVerkaufspreis()+ "; Verkäufer: " 
						+ it.getVerkäufer().getBenutzername() + "; Beschreibung: " + it.getBeschreibung() + "]\n";
					}
				}
			} //else {System.out.println("not str");}
		}
		if (str != "") str = (str + '\n');
		return str;
	}
}