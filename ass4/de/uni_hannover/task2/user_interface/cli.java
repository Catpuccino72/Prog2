package de.uni_hannover.task2.user_interface;
import de.uni_hannover.task2.Marketplace;
import de.uni_hannover.task2.auth.User;
import de.uni_hannover.task2.offerings.Item;
import de.uni_hannover.task2.offerings.Category;

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
    /** saves the user accessing the marketplace. */
    User user;

    public cli(Marketplace marketplace, User user) {
        mp = marketplace;
        this.user = user;
    }
    
    public void main_menu() {
        while (true) {
            int input;
            System.out.println("Wählen Sie aus den folgenden Optionen: \n1. Item hinzufügen \n2. Item entfernen \n3. Marketplace anssehen \n4. Item \n5. Programm beenden");
            input = new java.util.Scanner(System.in).nextInt();
            while (input < 1 || input > 5) {
                input = new java.util.Scanner(System.in).nextInt();
            }
            if (input == 1) add_item();
            if (input == 2) remove_item();
            if (input == 3) show_marketplace();
            if (input == 4) item();
            if (input == 5) System.exit(0);
        }
        
    }

    public void add_item() {
        int entry = 1;
        String input = "";

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
                    category_int = new java.util.Scanner(System.in).nextInt();
                    if (category_int > 0 && category_int < 4) {
                        if (category_int == 1) Kategorie = Category.FURNITURE;
                        if (category_int == 2) Kategorie = Category.ELECTRONICS;
                        if (category_int == 3) Kategorie = Category.OTHER;
                        break;
                    }
                    if (category_int == 4) System.exit(0);
                }
            }

            if (entry == 2) {
                Verkaufspreis = new java.util.Scanner(System.in).nextFloat();
            } else if (entry < 4){
                input = new java.util.Scanner(System.in).nextLine();
                if (input.equals("4")) System.exit(0);
                if (input.equals("abbruch")) return;
            }
            
            

            if (entry == 1) {
                duplicate_name = false;
                for (Item i: user.getItems()) {
                    if (i.getName().equals(input)) {
                        System.out.println("anderes Item mit demselben Namen bereits vorhanden!");
                        duplicate_name = true;
                    }
                }

                if (!duplicate_name && !input.equals("")) {
                    Name = input;
                    entry++;
                    System.out.println("");
                    continue;
                }
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
            if (entry == 4) break;
        }
        user.addItem(new Item(Name, Verkaufspreis, user, Beschreibung, Kategorie));
    }

    public void remove_item() {
        String input;
        System.out.println("Bitte geben Sie den Namen des Items an, welches entfernt werden soll");
        System.out.println(mp.filterMarketbyUser(user));
        input = new java.util.Scanner(System.in).nextLine();
        for (int n = 0; n < user.getItems().length; n++) {
            if (user.getItems()[n].getName().equals(input)) {
                System.out.println("entfernt!");
                user.removeItem(user.getItems()[n]);
                return;
            }
            System.out.println("nicht gefunden!");
        }
    }

    public void show_marketplace() {
        int input;
        System.out.println("Welche Kategorie wollen Sie sich anschauen: \n1. Alle \n2. FURNITURE \n3. ELECTRONICS \n4. OTHER \n5. Programm beenden");
        input = new java.util.Scanner(System.in).nextInt();
        while (input < 1 || input > 4) {
            input = new java.util.Scanner(System.in).nextInt();
        }
        if (input == 1) System.out.println(mp.str());
        if (input == 2) System.out.println(mp.filterMarket(Category.FURNITURE));
        if (input == 3) System.out.println(mp.filterMarket(Category.ELECTRONICS));
        if (input == 4) System.out.println(mp.filterMarket(Category.OTHER));
        if (input == 5) System.exit(0);
    }

    public void item() {
        int input;
        String str_input;
        Item item = null;

        if (user.getItems().length < 1){
            System.out.println("keine Items vorhanden!");
            return;
        }

        System.out.print("Wählen Sie aus den folgenden Items: ");
        System.out.println(mp.filterMarketbyUser(user));
        System.out.println("um zum Hauptmenü zurückzukehren: abbruch");
        while(true) {
            str_input = new java.util.Scanner(System.in).nextLine();
            if (str_input.equals("abbruch")) return;
            for (int n = 0; n < user.getItems().length; n++) {
                if (user.getItems()[n].getName().equals(str_input)) {
                    item = (user.getItems()[n]);
                    break;
                }
                System.out.println("Item mit diesem Namen nicht vorhanden!");
            }
            if (item != null) break;
        }

        System.out.println("Wählen Sie aus den folgenden Optionen: \n1. Name \n2. Verkaufspreis \n3. Beschreibung \n4. Kategorie \n5. Programm beenden");
        input = new java.util.Scanner(System.in).nextInt();
        while (input < 1 || input > 4) {
            if (input == 5) System.exit(0);
            input = new java.util.Scanner(System.in).nextInt();
        }

        String str = "";
        float Verkaufspreis = -1;
        int category_int = -1;
        Category Kategorie = Category.OTHER;
        boolean duplicate_name;

        if (input == 1 || input == 3) {
            if (input == 1) System.out.print("neuer Name: ");
            if (input == 3) System.out.print("neue Beschreibung: ");
            str = new java.util.Scanner(System.in).nextLine();
            if (input == 1) {
                duplicate_name = false;
                for (Item i: user.getItems()) {
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
            Verkaufspreis = new java.util.Scanner(System.in).nextFloat();
            item.setVerkaufpreis(Verkaufspreis);
        }

        if (input == 4) {
            System.out.println("Wählen Sie aus den folgenden Optionen: \n1. FURNITURE \n2. ELECTRONICS \n3. OTHER \n4. Programm beenden");
            while (true) {
                category_int = new java.util.Scanner(System.in).nextInt();
                if (category_int > 0 && category_int < 4) {
                    if (category_int == 1) Kategorie = Category.FURNITURE;
                    if (category_int == 2) Kategorie = Category.ELECTRONICS;
                    if (category_int == 3) Kategorie = Category.OTHER;
                    item.setCategory(Kategorie);
                    break;
                }
                if (category_int == 4) System.exit(0);
            }   
        }      
    }
}