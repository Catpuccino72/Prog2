package de.uni_hannover.task2;
import java.util.Scanner;

import de.uni_hannover.task2.auth.*;
import de.uni_hannover.task2.offerings.*;
import de.uni_hannover.task2.communication.*;

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
	public String username;
	
	/**
	 * This method creates an initial marketplace with a maximum of 10 users.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 */
	public Marketplace() {
		this.Users = new User[10];
		this.username = null;
	}
	
	/**
	 * This method adds an user to the marketplace.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param user_to_insert the user to add.
	 * @return if the user was added.
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
				if (us.getItems().length != 0) str = str + "\nUser: " + us.getBenutzername() + "\n";
				for (Item it: us.getItems()) {
					if (it != null) {
						str = str + "[Item: " + it.getName() + "; Kategorie: " + it.getCategory().str() + "; Preis: " + it.getVerkaufspreis()+ "; Verkäufer: " 
						+ it.getVerkäufer() + "; Beschreibung: " + it.getBeschreibung() + "]\n";
					}
				}
			}
		}
		if (str != "") str = (str + '\n');
		return str;
	}
	
	/**
	 * This method returns a string representation of the marketplace filtered by category.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param category the category to filter by.
	 * @return the marketplace as a String.
	 */
	public String filterMarket(Category category){
		String str = "\n\nMARKETPLACE \n";
		for (User us: this.Users) {
			if (us != null) {
				if (us.getItems().length != 0) str = str + "\nUser: " + us.getBenutzername() + "\n";
				for (Item it: us.getItems()) {
					if (it != null && it.getCategory() == category) {
						str = str + "[Item: " + it.getName() + "; Kategorie: " + it.getCategory().str() + "; Preis: " + it.getVerkaufspreis()+ "; Verkäufer: " 
						+ it.getVerkäufer() + "; Beschreibung: " + it.getBeschreibung() + "]\n";
					}
				}
			}
		}
		if (str != "") str = (str + '\n');
		return str;
	}
	
	/**
	 * This method returns a string representation of the marketplace filtered by the user.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param user the user to filter by.
	 * @return the marketplace as a String.
	 */
	public String filterMarketbyUser(String username){
		String str = "\n\nMARKETPLACE \n";
		for (Item it: Communicator.getUserItems(username)) {
			if (it != null) {
				str = str + "[Item: " + it.getName() + "; Kategorie: " + it.getCategory().str() + "; Preis: " + it.getVerkaufspreis()+ "; Verkäufer: " 
				+ it.getVerkäufer() + "; Beschreibung: " + it.getBeschreibung() + "]\n";
			}
		}
		if (str != "") str = (str + '\n');
		return str;
	}

	/**
	 * This method searches for the user that matches both the username and the password.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param username the username of the login credetials pair.
	 * @param password the password of the login credetials pair.
	 * @return the user that matches the login credentials.
	 */
	public void login(String user, String password){
		Scanner s = new java.util.Scanner(System.in);
		while (true) {
			System.out.println("login: l | register: r");
			String input = s.nextLine();
			if (input.equals("r")) {
				while (true) {
					if (Communicator.register(user, password)) System.exit(0);

					System.out.println("try again");
					System.out.print("username: ");
					username = s.nextLine();
					System.out.print("password: ");
					password = s.nextLine();
				}

			} else if (input.equals("l")) {
				if (Communicator.login(user, password)) {
					this.username = user;
					return;
				} else {
					System.out.println("FALSCHER BENUTZER ODER PASSWORT!");
					System.exit(0);
				}
			}
			
		}
	}
}