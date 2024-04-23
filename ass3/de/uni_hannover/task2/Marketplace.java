package de.uni_hannover.task2;
import de.uni_hannover.task2.auth.*;
import de.uni_hannover.task2.offerings.*;

/**
 * This class provides multiple methods to manage the marketplace.
 * It also implements methods to print the state of the marketplace.
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 April 22
 */
public class Marketplace{
	/** saves all of the users. */
	public User[] Users;
	
	/**
	 * This method creates an initial marketplace with a maximum of 10 users.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 */
	public Marketplace() {
		this.Users = new User[10];
	}
	
	/**
	 * This method adds an user to the marketplace.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param user_to_insert the user to add
	 * @return if the user was added
	 */
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
	
	/**
	 * This method returns a string representation of the marketplace.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the marketplace as a String.
	 */
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
	
	/**
	 * This method returns a filtered string representation of the marketplace.
	 * It filters by category.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the marketplace as a String.
	 */
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