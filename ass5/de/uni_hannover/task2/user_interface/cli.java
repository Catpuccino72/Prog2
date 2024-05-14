package de.uni_hannover.task2.user_interface;
import java.util.Scanner;

import javax.management.ConstructorParameters;

import de.uni_hannover.task2.Marketplace;
import de.uni_hannover.task2.auth.User;
import de.uni_hannover.task2.offerings.Item;
import de.uni_hannover.task2.offerings.Category;
import de.uni_hannover.task2.communication.*;

/**
 * This class provides multiple methods to manage the interface of the marketplace.
 * It also uses a user to decide whether a user is allowed to change the properties of an item.
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 April 22
 */
public class cli {
    /** saves the marketplace */
    Marketplace mp;
    /** saves the user accessing the marketplace */
    String username;
    /** user input */
    Scanner scanner = new Scanner(System.in);

    /**
     * Constructor for cli
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
     * @param marketplace the marketplace that will be used.
     * @param user the user that uses the marketplace.
     */
    public cli(Marketplace marketplace, String username) {
        mp = marketplace;
        this.username = username;
    }
    
    /**
     * This method implements the main menu if the interface.
     * It accepts the numbers 1-5 to access options.
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
     */
    public void main_menu() {
        while (true) {
            int input;
            System.out.println("Wählen Sie aus den folgenden Optionen: \n1. Item hinzufügen \n2. Item entfernen \n3. Marketplace anssehen \n4. Item \n5. Programm beenden");
            input = scanner.nextInt();
            while (input < 1 || input > 5) {
                input = scanner.nextInt();
            }
            if (input == 1) add_item();
            if (input == 2) remove_item();
            if (input == 3) show_marketplace();
            if (input == 4) item();
            if (input == 5) System.exit(0);
        }
        
    }

    /**
     * This method implements the interface for adding an item.
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
     */
    public void add_item() {
        int entry = 1;
        String input = "";

        String Besitzer = "";
        String Name = "";
        float Verkaufspreis = -1;
        String Beschreibung = "";
        int category_int = -1;
        Category Kategorie = Category.OTHER;
        boolean duplicate_name;

        System.out.println("um zum Hauptmenü zurückzukehren: abbruch");
        while(true) {
            if (entry == 1) System.out.print("Name: ");
            if (entry == 2) System.out.print("Verkaufspreis: ");
            if (entry == 3) System.out.print("Beschreibung: ");
            if (entry == 4) {
                System.out.println("Kategorie: ");
                System.out.println("Wählen Sie aus den folgenden Optionen: \n1. FURNITURE \n2. ELECTRONICS \n3. OTHER \n4. Programm beenden");
                while (true) {
                    category_int = scanner.nextInt();
                    if (category_int > 0 && category_int < 4) {
                        if (category_int == 1) Kategorie = Category.FURNITURE;
                        if (category_int == 2) Kategorie = Category.ELECTRONICS;
                        if (category_int == 3) Kategorie = Category.OTHER;
                        entry++;
                        break;
                    }
                    if (category_int == 4) System.exit(0);
                }
            }
            if (entry == 5) System.out.print("Verkäufer: ");

            if (entry == 2) {
                Verkaufspreis = scanner.nextFloat();
            } else if (entry < 5){
                input = new java.util.Scanner( System.in ).nextLine();
                if (input.equals("4")) System.exit(0);
                if (input.equals("abbruch")) return;
            }
            
            if (entry == 1) {
                Name = input;
                entry++;
                System.out.println("");
                continue;
            }
            if (entry == 2) {
                if (Verkaufspreis != -1) entry++;
                System.out.println("");
                continue;
            } 
            if (entry == 3) {
                if (!input.equals("")) entry++;
                Beschreibung = input;
                System.out.println("");
                continue;
            }
            if (entry == 5) {
                Besitzer = new java.util.Scanner( System.in ).nextLine();
                entry++;
            }
            if (entry == 6) break;
        }
        Item it = new Item(Name, Verkaufspreis, username, Beschreibung, Kategorie);
        Communicator.addItem(Besitzer, it);
    }
    /**
     * This method implements the interface for removing an item.
     * It asks for the items name and removes it if it exists and the user is the seller of the item.
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
     */
    public void remove_item() {
        if (Communicator.getUserItems(username).length < 1) {
            System.out.println("no items to remove");
            return;
        }
        String input;
        System.out.println("Bitte geben Sie den Namen des Items an, welches entfernt werden soll");
        System.out.println(mp.filterMarketbyUser(username));
        input = new java.util.Scanner(System.in).nextLine();

        for (int n = 0; n < Communicator.getUserItems(username).length; n++) {
            if (Communicator.getUserItems(username)[n].getName().equals(input)) {
                System.out.println("entfernt!");
                Communicator.removeItem(Communicator.getUserItems(username)[n]);
                return;
            }
        }
        System.out.println("nicht gefunden!");
    }

    /**
     * This method implements the interface for showing the items on the marketplace.
     * It also allows to filter the market by categories.
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
     */
    public void show_marketplace() {
        int input;
        System.out.println("Welche Kategorie wollen Sie sich anschauen: \n1. FURNITURE \n2. ELECTRONICS \n3. OTHER \n4. Programm beenden");
        do {
            input = scanner.nextInt();
        } while (input < 1 || input > 4);
        Category cat = Category.OTHER;
        switch (input) {
            case 1 -> cat = Category.FURNITURE;
            case 2 -> cat = Category.ELECTRONICS;
            case 3 -> cat = Category.OTHER;
            case 4 -> System.exit(0);
            default -> System.out.println("ERROR, wrong input");
        }
        Item[] filtered_items = Communicator.getItems(cat);
        for (Item it: filtered_items) {
            System.out.print(it.str());
        }
    }

    /**
     * This method implements the interface for changing the properties of an item.
     * it won´t allow to change to properties of an item of another user.
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
     */
    public void item() {
        int input;
        String str_input;
        Item item = null;
        
        if (Communicator.getUserItems(username).length < 1){
            System.out.println("keine Items vorhanden!");
            return;
        }

        System.out.print("Wählen Sie aus den folgenden Items: ");
        System.out.println(mp.filterMarketbyUser(username));
        System.out.println("um zum Hauptmenü zurückzukehren: abbruch");
        while(true) {
            str_input = new java.util.Scanner( System.in ).nextLine();
            if (str_input.equals("abbruch")) return;
            for (int n = 0; n < Communicator.getUserItems(username).length; n++) {
                if (Communicator.getUserItems(username)[n].getName().equals(str_input)) {
                    item = (Communicator.getUserItems(username)[n]);
                    break;
                } else {
                    System.out.println("Item mit diesem Namen nicht vorhanden!");
                }
            }
            if (item != null) break;
        }

        System.out.println("Wählen Sie aus den folgenden Optionen: \n1. Name \n2. Verkaufspreis \n3. Beschreibung \n4. Kategorie \n5. Programm beenden");
        input = scanner.nextInt();
        while (input < 1 || input > 4) {
            if (input == 5) System.exit(0);
            input = scanner.nextInt();
        }

        String str = "";
        float Verkaufspreis = -1;
        String category_int = "";
        Category Kategorie = Category.OTHER;
        boolean duplicate_name;

        if (input == 1 || input == 3) {
            if (input == 1) System.out.print("neuer Name: ");
            if (input == 3) System.out.print("neue Beschreibung: ");
            str = new java.util.Scanner( System.in ).nextLine();
            if (input == 1) {
                duplicate_name = false;
                for (Item i: Communicator.getUserItems(username)) {
                    if (i.getName().equals(str)) {
                        System.out.println("anderes Item mit demselben Namen bereits vorhanden!");
                        duplicate_name = true;
                    }
                }
                if (!duplicate_name) item.setName(str);
                
            }
            if (input == 3) item.setBeschreibung(str);
        }

        if (input == 2) {
            System.out.print("neuer Verkaufpreis: ");
            Verkaufspreis = scanner.nextFloat();
            item.setVerkaufpreis(Verkaufspreis);
        }

        if (input == 4) {
            System.out.println("Wählen Sie aus den folgenden Optionen: \n1. FURNITURE \n2. ELECTRONICS \n3. OTHER \n4. Programm beenden");
            while (true) {
                input = 5;
                category_int = new java.util.Scanner( System.in ).nextLine();

                if (category_int.equals("1")) {
                    Kategorie = Category.FURNITURE;
                    item.setCategory(Kategorie);
                    break;
                } else if (category_int.equals("2")) {
                    Kategorie = Category.ELECTRONICS;
                    item.setCategory(Kategorie);
                    break;
                } else if (category_int.equals("3")) {
                    Kategorie = Category.OTHER;
                    item.setCategory(Kategorie);
                    break;
                } else {
                    input = 4;
                }
                 
                if (category_int.equals("4")) System.exit(0);
            }   
        }
        Communicator.updateItem(item);
    }
}