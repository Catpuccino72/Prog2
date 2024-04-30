package de.uni_hannover.task2.offerings;

/**
 * This enum provides the categorization of Items.
 * 
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 April 22
 */
public enum Category{
	/**the category furniture */
	FURNITURE,
	/**the category electronics */
	ELECTRONICS,
	/**the category other */
	OTHER;
	
	/**
	 * This method provides a function to return the corresponding String of an item.
	 * 
	 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @return the corresponding String of the item.
	 */
	public String str(){
		switch (this) {
			case FURNITURE:
				return "FURNITURE";
			case ELECTRONICS:
				return "ELECTRONICS";
			case OTHER:
				return "OTHER";
			default:
				return "error";
		}
	}
};