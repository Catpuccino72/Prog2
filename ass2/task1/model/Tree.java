package model;

public class Tree {
	private int value;
	private Tree right;
	private Tree left;
	
	public Tree(int value) {
		this.value = value;
	}
	
	public void setLeft(Tree left) {
		this.left = left;
	}
	
	public void setRight(Tree right) {
		this.right = right;
	}
	
	public Tree getLeft() {
		return this.left;
	}
	
	public Tree getRight() {
		return this.right;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String str() {
		
		// kein weiterer Teilbaum
		if (this.left == null && this.right == null) {
			return (value + "");
		}
		
		// nur links
		if(this.left != null && this.right == null) {
			return (this.left.str() + " " + this.value);
		}
		
		// nur rechts
		if (this.left == null && this.right != null) {
			return (this.value + " " + this.right.str());
		}
		
		// beide Teilbäume exisitieren
		return (this.left.str() + " " + this.value + " " + this.right.str());
	}
	
	public void insertValue(int value) {
		if (this.value == value) {
			return;
		}
		
		if (value > this.value) {
			if (this.right == null) {
				this.right = new Tree(value);
			} else {
				this.right.insertValue(value);
			}
		} else {
			if (this.left == null) {
				this.left = new Tree(value);
			} else {
				this.left.insertValue(value);
			}
		}
		return;
	}
	
	public boolean contains(int value) {
		if (this == null) return false;
		if (this.value == value) return true;
		if (value > this.value && this.right != null) return this.right.contains(value);
		if (value < this.value && this.left != null) return this.left.contains(value);
		return false;
	}
}