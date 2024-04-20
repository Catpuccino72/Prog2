package de.uni_hannover.task2;
import de.uni_hannover.task2.Marketplace;
import de.uni_hannover.task2.auth.*;
import de.uni_hannover.task2.offerings.*;


class Main {
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
		
		User Rewe_duplicate = new User("Rewe", "EinsicheresPasswort");
		
		Item it1 = new Item("Lecker Bierchen", (float) 0.89, Rewe, "0.89€ zzgl. 25Ct Pfand");
		Item it2 = new Item("Lecker Apfelkuch", (float) 2.49, Rewe, "vegetarisch");
		Item it3 = new Item("Lecker Sprudelwasser", (float) 0.19, Rewe, "sprudelt zzgl. 25Ct Pfand");
		Item it4 = new Item("Lecker Spezi", (float) 1.19, Rewe, "im Angebot");
		Item it5 = new Item("Pfand", (float) -3.5, Rewe, "14 x 0,25Ct");
		
		mp.addUser(Rewe);
		mp.addUser(Rewe_duplicate);
		System.out.print(mp.str());
		
		
		mp.addUser(Kunde);
		System.out.print(mp.str());
		
		
		
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
		
		mp.addUser(Kunde1);
		mp.addUser(Kunde2);
		mp.addUser(Kunde3);
		mp.addUser(Kunde4);
		mp.addUser(Kunde5);
		mp.addUser(Kunde6);
		mp.addUser(Kunde7);
		mp.addUser(Kunde8);
		mp.addUser(Kunde9);
		
		
		
		/*
		for (int n = 0; n < mp.Users.length; n++) {
			if (n == 0) System.out.println("\n\n---MARKETPLACE USERS---\n");
			System.out.println(mp.Users[n]);
		}
		
		
		System.out.println("\n");
		for (User us: mp.Users) {
			if (us == null) continue;
			for(Item it: us.getItems()) {
				if (it == null) continue;
				System.out.println("Item: " + it.getName());
			}
		}
		*/
	}
}
