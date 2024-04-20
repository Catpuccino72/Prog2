package de.uni_hannover.task2;
import de.uni_hannover.task2.auth.*;
import de.uni_hannover.task2.offerings.*;

public class Marketplace{
	public User[] Users;
	
	public Marketplace() {
		this.Users = new User[10];
	}
	
	public boolean addUser(User user_to_insert) {
		
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
				for (Item it: us.getItems()) {
					if (it != null) {
						str = str + "[Item: " + it.getName() + "; Preis: " + it.getVerkaufspreis()+ "; Verkäufer: " 
						+ it.getVerkäufer().getBenutzername() + "; Beschreibung: " + it.getBeschreibung() + "]\n";
					}
				}
			}
		}
		if (str != "") str = (str + '\n');
		return str;
	}
	
	public String filterMarket(Category category){
		String str = "\n\nMARKETPLACE \n";
		for (User us: this.Users) {
			if (us != null) {
				str = str + "\nUser: " + us.getBenutzername() + "\n";
				for (Item it: us.getItems()) {
					if (it != null && it.getCategory() == category) {
						str = str + "[Item: " + it.getName() + "; Kategorie: " + it.getCategory().str() + "; Preis: " + it.getVerkaufspreis()+ "; Verkäufer: " 
						+ it.getVerkäufer().getBenutzername() + "; Beschreibung: " + it.getBeschreibung() + "]\n";
					}
				}
			}
		}
		if (str != "") str = (str + '\n');
		return str;
	}
}