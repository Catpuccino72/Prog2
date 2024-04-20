package de.uni_hannover.task2.auth;

import de.uni_hannover.task2.offerings.*;

public class User{
	private String Benutzername;
	private String Passwort;
	private Item[] Items;
	
	public User(String Benutzername, String Passwort) {
		this.Benutzername = Benutzername;
		this.Passwort = Passwort;
		this.Items = new Item[0];
	}
	
	public void setBenutzername(String Benutzername) {
		this.Benutzername = Benutzername;
	}
	
	public void setPasswort(String Passwort) {
		this.Passwort = Passwort;
	}
	
	//public void setItem(Item item, int index) {
	//	this.Items[index] = item;
	//}
	
	public void setItems(Item[] it) {
		this.Items = it;
	}
	
	public String getBenutzername() {
		return this.Benutzername;
	}
	
	public String getPasswort() {
		return this.Passwort;
	}
	
	//public Item getItem(int Index) {
	//	return this.Items[Index];
	//}
	
	public Item[] getItems() {
		return this.Items;
	}
	
	
	public boolean removeItem (Item item) {
		int index = 0;
		for (Item i: this.Items) {
			
			if (i == item) {
				for (int n = index; n < (this.Items.length - 1); n++) {
					this.Items[index] = this.Items[index + 1];
				}
				this.Items[this.Items.length - 1] = null;
				
				// create new array of length previous-1
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
		//System.out.println("added new Item: " + item.getName() 
		//+ " -- User: " + this.getBenutzername() + " -- new length of item array: " + newItems.length);
		return true;
	}
}