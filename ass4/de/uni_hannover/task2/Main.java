package de.uni_hannover.task2;
import de.uni_hannover.task2.user_interface.*;
import de.uni_hannover.task2.Marketplace;
import de.uni_hannover.task2.auth.*;
import de.uni_hannover.task2.offerings.*;

/**
 * This class tests the program.
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 April 22
 */
class Main {

	/**
	 * This method adds users and items to the marketplace and prints the state of the marketplace each time
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the game state as a String
	 */
	public static void main (String[] args) {
		Marketplace mp = new Marketplace();
		
		User Kunde = new User("Kunde", "1234");
		User Kunde1 = new User("Kunde1", "1234");
		User Kunde2 = new User("Kunde2", "1234");
		User Kunde3 = new User("Kunde3", "1234");
		User Kunde4 = new User("Kunde4", "1234");
		User Kunde5 = new User("Kunde5", "1234");
		User Kunde6 = new User("Kunde6", "1234");
		User Kunde7 = new User("Kunde7", "1234");
		User Kunde8 = new User("Kunde8", "1234");
		User Kunde9 = new User("Kunde9", "1234");
		
		User Rewe = new User("Rewe", "EinsicheresPasswort");
		
		
		Item it1 = new Item("Lecker Stuhl", (float) 0.89, Rewe, "0.89€ zzgl. 25Ct Pfand", Category.FURNITURE);
		/* 
		Item it2 = new Item("Lecker Motherboard", (float) 2.49, Rewe, "vegetarisch", Category.ELECTRONICS);
		Item it3 = new Item("Lecker Kupferkabel", (float) 0.19, Rewe, "sprudelt zzgl. 25Ct Pfand", Category.ELECTRONICS);
		Item it4 = new Item("Lecker Spezi", (float) 1.19, Rewe, "im Angebot", Category.OTHER);
		Item it5 = new Item("Pfand", (float) -3.5, Rewe, "14 x 0,25Ct", Category.OTHER);
		*/
		
		mp.addUser(Rewe);
		
		mp.addUser(Kunde);
		
		/* 
		mp.Users[0].addItem(it1);
		System.out.print(mp.str());
		mp.Users[0].removeItem(it1);
		
		mp.Users[0].addItem(it1);
		System.out.print(mp.str());
		mp.Users[0].removeItem(it1);
		
		mp.Users[1].addItem(it2);
		System.out.print(mp.str());
		mp.Users[1].removeItem(it2);
		
		mp.Users[1].addItem(it3);
		System.out.print(mp.str());
		mp.Users[1].removeItem(it3);
		
		mp.Users[0].addItem(it4);
		System.out.print(mp.str());
		mp.Users[0].removeItem(it4);
		
		mp.Users[0].addItem(it5);
		System.out.print(mp.str());
		mp.Users[0].removeItem(it5);
		*/

		mp.addUser(Kunde1);
		mp.addUser(Kunde2);
		mp.addUser(Kunde3);
		mp.addUser(Kunde4);
		mp.addUser(Kunde5);
		mp.addUser(Kunde6);
		mp.addUser(Kunde7);
		mp.addUser(Kunde8);
		
		
		mp.Users[0].addItem(it1);
		/*
		mp.Users[0].addItem(it2);
		mp.Users[0].addItem(it3);
		mp.Users[0].addItem(it4);
		mp.Users[0].addItem(it5);
		
		System.out.print(mp.filterMarket(Category.ELECTRONICS));
		System.out.print(mp.filterMarket(Category.FURNITURE));
		System.out.print(mp.filterMarket(Category.OTHER));
		*/
		User user_login;
		while(true) {
			int attempts = 0;
			while (true) {
				System.out.print("Geben Sie den Benutzernamen ein: ");
				String Benutzer = new java.util.Scanner(System.in).nextLine();
			
				System.out.print("Geben Sie das Passwort ein: ");
				String Passwort = new java.util.Scanner(System.in).nextLine();

				user_login = mp.login(Benutzer, Passwort);
				if (user_login != null) break;

				attempts++;
				if (attempts == 3) System.exit(0);
			}
			cli user_interface = new cli(mp, user_login);
			user_interface.main_menu();
		}
	}
}
