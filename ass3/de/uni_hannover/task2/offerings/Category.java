package de.uni_hannover.task2.offerings;

public enum Category{
	FURNITURE,
	ELECTRONICS,
	OTHER;
	
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