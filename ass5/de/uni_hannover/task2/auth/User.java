package de.uni_hannover.task2.auth;
import de.uni_hannover.task2.offerings.*;

/**
 * This class provides multiple methods to manage an user.
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 April 22
 */
public class User{
	/** the username of the user */
	private String Benutzername;
	/** the password of the user */
	private String Passwort;
	/** all of the items if an user */
	private Item[] Items;
	
	/**
	 * This method creates an user.
	 * It also sets his username and password.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 */
	public User(String Benutzername, String Passwort) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.Items = new Item[0];
	}
	
	/**
	 * This method sets the username of the user.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param Benutzername the new username as a String to set.
	 */
	public void setBenutzername(String Benutzername) {
		this.Benutzername = Benutzername;
	}
	
	/**
	 * This method sets the password of the user.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param Passwort the new password as a String to set.
	 */
	public void setPasswort(String Passwort) {
		this.Passwort = Passwort;
	}
	
	/**
	 * This method sets the Items of the user.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param it an Item array of the items to set.
	 */
	public void setItems(Item[] it) {
		this.Items = it;
	}
	
	/**
	 * This method returns the username of the user.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the username of the user.
	 */
	public String getBenutzername() {
		return this.Benutzername;
	}
	
	/**
	 * This method returns the password of the user.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the password of the user.
	 */
	public String getPasswort() {
		return this.Passwort;
	}
	
	/**
	 * This method returns the Items of the user.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the Items of the user.
	 */
	public Item[] getItems() {
		return this.Items;
	}
	
	/**
	 * This method removes an item from the user.
	 * It returns false if it was not found, otherwise it removes it and returns true.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param item the item to be removed.
	 * @return whether the item was removed.
	 */
	public boolean removeItem (Item item) {
		int index = 0;
		for (Item i: this.Items) {
			
			if (i == item) {
				for (int n = index; n < (this.Items.length - 1); n++) {
					this.Items[index] = this.Items[index + 1];
				}
				this.Items[this.Items.length - 1] = null;

				index = 0;
				Item[] newItems = new Item[this.Items.length - 1];
				for (Item it: this.Items) {
					if (it == null) continue;
					newItems[index] = it;
					index++;
				}
				
				this.Items = newItems;
				return true;
			}
			index++;
		}
		return false;
	}
	
	/**
	 * This method adds an item from the user.
	 * It returns false if the item already exists and won´t be added, otherwise it adds it and returns true.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param item the item to be added.
	 * @return whether the item was added.
	 */
	public boolean addItem (Item item) {
		for (Item i: this.Items) {
			if (i == item) return false;
		}
		Item[] newItems = new Item[this.Items.length + 1];
		for (int n = 0; n < this.Items.length; n++) {
			newItems[n] = this.Items[n];
		}
		newItems[newItems.length - 1] = item;
		this.Items = newItems;
		return true;
	}
}