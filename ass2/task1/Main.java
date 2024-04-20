import model.*;
public class Main {
	public static void main (String[] args) {
		Tree tree = new Tree(10);
		
		
		tree.setRight(new Tree(12));
		tree.setLeft(new Tree(-2));
		if (tree.getLeft().getValue() == -2) System.out.println("test passed!");
		else System.out.println("test failed! actual value: " + tree.getLeft().getValue() + " expected value: -2");
		
		if (tree.getRight().getValue() == 12) System.out.println("test passed!");
		else System.out.println("test failed! actual value: " + tree.getRight().getValue() + " expected value: 12");
		
		
		tree.setRight(new Tree(20));
		tree.setLeft(new Tree(0));
		if (tree.getLeft().getValue() == 0) System.out.println("test passed!");
		else System.out.println("test failed! actual value: " + tree.getLeft().getValue() + " expected value: 0");
		
		if (tree.getRight().getValue() == 20) System.out.println("test passed!");
		else System.out.println("test failed! actual value: " + tree.getRight().getValue() + " expected value: 20");
		
		tree.setRight(new Tree(11111));
		tree.setLeft(new Tree(-8888));
		if (tree.getLeft().getValue() == -8888) System.out.println("test passed!");
		else System.out.println("test failed! actual value: " + tree.getLeft().getValue() + " expected value: -8888");
		
		if (tree.getRight().getValue() == 11111) System.out.println("test passed!");
		else System.out.println("test failed! actual value: " + tree.getRight().getValue() + " expected value: 11111");
		
		tree.setRight(new Tree(222));
		tree.setLeft(new Tree(5));
		if (tree.getLeft().getValue() == 5) System.out.println("test passed!");
		else System.out.println("test failed! actual value: " + tree.getLeft().getValue() + " expected value: 5");
		
		if (tree.getRight().getValue() == 222) System.out.println("test passed!");
		else System.out.println("test failed! actual value: " + tree.getRight().getValue() + " expected value: 222");
		
		tree.setRight(new Tree(7777777));
		tree.setLeft(new Tree(-99999999));
		if (tree.getLeft().getValue() == -99999999) System.out.println("test passed!");
		else System.out.println("test failed! actual value: " + tree.getLeft().getValue() + " expected value: -99999999");
		
		if (tree.getRight().getValue() == 7777777) System.out.println("test passed!");
		else System.out.println("test failed! actual value: " + tree.getRight().getValue() + " expected value: 7777777");
		
		tree.setRight(new Tree(11));
		tree.setLeft(new Tree(9));
		if (tree.getLeft().getValue() == 9) System.out.println("test passed!");
		else System.out.println("test failed! actual value: " + tree.getLeft().getValue() + " expected value: 9");
		
		if (tree.getRight().getValue() == 11) System.out.println("test passed!");
		else System.out.println("test failed! actual value: " + tree.getRight().getValue() + " expected value: 11");
		
		String s1 = "9 10 11";
		System.out.println(tree.str().equals(s1));
		tree.insertValue(8);
		s1 = "8 9 10 11";
		System.out.println(tree.str().equals(s1));
		
		tree.insertValue(22);
		s1 = "8 9 10 11 22";
		System.out.println(tree.str().equals(s1));
		tree.insertValue(0);
		s1 = "0 8 9 10 11 22";
		System.out.println(tree.str().equals(s1));
		tree.insertValue(0);
		s1 = "0 8 9 10 11 22";
		System.out.println(tree.str().equals(s1));
		
		
		System.out.println(tree.contains(0));
		System.out.println(tree.contains(11));
		System.out.println(tree.contains(23));
	}
}