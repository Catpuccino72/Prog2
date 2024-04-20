package de.uni_hannover.task2.offerings;
import de.uni_hannover.task2.auth.*;
import de.uni_hannover.task2.offerings.*;

public class Item {
	private String Name;
	private float Verkaufspreis;
	private User Verkäufer;
	private String Beschreibung;
	private Category Category;
	
	public Item(String Name, float Verkaufspreis, User Verkäufer, String Beschreibung, Category cat){
		this.Name = Name;
		this.Verkaufspreis = Verkaufspreis;
		this.Verkäufer = Verkäufer;
		this.Beschreibung = Beschreibung;
		this.Category = cat;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public void setVerkaufpreis(float Verkaufspreis) {
		this.Verkaufspreis = Verkaufspreis;
	}
	
	public void setVerkäufer(User Verkäufer) {
		this.Verkäufer = Verkäufer;
	}
	
	public void setBeschreibung(String Beschreibung) {
		this.Beschreibung = Beschreibung;
	}
	
	public void setCategory(Category cat) {
		this.Category = cat;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public float getVerkaufspreis() {
		return this.Verkaufspreis;
	}
	
	public User getVerkäufer() {
		return this.Verkäufer;
	}
	
	public String getBeschreibung() {
		return this.Beschreibung;
	}
	
	public Category getCategory() {
		return this.Category;
	}
	
	public String str(){
		return "[Item: " + this.getName() + "; Kategorie: " + this.getCategory().str() + "; Preis: " + this.getVerkaufspreis()+ "; Verkäufer: " 
		+ this.getVerkäufer().getBenutzername() + "; Beschreibung: " + this.getBeschreibung() + "]\n";
	}
}