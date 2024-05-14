package de.uni_hannover.task2.offerings;
import de.uni_hannover.task2.auth.*;
import de.uni_hannover.task2.offerings.*;

/**
 * This class provides the methods to manage items.
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 April 22
 */
public class Item {
	/** the name of the item */
	private String Name;
	/** the price of the item */
	private float Verkaufspreis;
	/** the seller of the item */
	private String owner;
	/** the description of the item */
	private String Beschreibung;
	/** the category of the item */
	private Category Category;
	/** the id of the item */
	int itemId;
	
	/**
	 * This method creates an item.
	 * It also sets its name, price, seller, description and category.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 */
	public Item(String Name, float Verkaufspreis, String Verkäufer, String Beschreibung, Category cat){
		this.Name = Name;
		this.Verkaufspreis = Verkaufspreis;
		this.owner = Verkäufer;
		this.Beschreibung = Beschreibung;
		this.Category = cat;
		this.itemId = -1;
	}

	public Item(int itemId, String name, float price, String owner, String description, Category category) {
		this.Name = name;
		this.Verkaufspreis = price;
		this.owner = owner;
		this.Beschreibung = description;
		this.Category = category;
		this.itemId = itemId;
	}
	
	/**
	 * This method sets the name of the item.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param Name the new name as a String to set.
	 */
	public void setName(String Name) {
		this.Name = Name;
	}
	
	/**
	 * This method sets the price of the item.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param Verkaufspreis the new price as a float to set.
	 */
	public void setVerkaufpreis(float Verkaufspreis) {
		this.Verkaufspreis = Verkaufspreis;
	}
	
	/**
	 * This method sets the seller of the item.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param Verkäufer the new seller to set.
	 */
	public void setVerkäufer(String Verkäufer) {
		this.owner = Verkäufer;
	}
	
	/**
	 * This method sets the description of the item.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param Beschreibung the new description to set.
	 */
	public void setBeschreibung(String Beschreibung) {
		this.Beschreibung = Beschreibung;
	}
	
	/**
	 * This method sets the category of the item.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param cat the new category to set.
	 */
	public void setCategory(Category cat) {
		this.Category = cat;
	}
	
	/**
	 * This method returns the name of the item.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the name of the item.
	 */
	public String getName() {
		return this.Name;
	}
	
	/**
	 * This method returns the name of the item.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the price of the item.
	 */
	public float getVerkaufspreis() {
		return this.Verkaufspreis;
	}
	
	/**
	 * This method returns the seller of the item.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the seller of the item.
	 */
	public String getVerkäufer() {
		return this.owner;
	}
	
	/**
	 * This method returns the description of the item.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the description of the item.
	 */
	public String getBeschreibung() {
		return this.Beschreibung;
	}
	
	/**
	 * This method returns the category of the item.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the category of the item.
	 */
	public Category getCategory() {
		return this.Category;
	}

	/**
	 * This method returns the item_id of the item.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the id of the item.
	 */
	public int getItemId() {
		return this.itemId;
	}

	
	/**
	 * This method returns the string representation of the item.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the string representation of the item.
	 */
	public String str(){
		return "[Item: " + this.getName() + "; Kategorie: " + this.getCategory().str() + "; Preis: " + this.getVerkaufspreis()+ "; Verkäufer: " 
		+ this.getVerkäufer() + "; Beschreibung: " + this.getBeschreibung() + "]\n";
	}
}