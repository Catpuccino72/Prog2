/**
 * This class implements the super class of a logic gate.
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 April 30
 */
public class Gate {
	/** the corresponding symbol of the gate */
	public String symbol = " ";
	
	/**
     * This method implements the logic of the Gate.
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param a the first boolean.
	 * @param b the second boolean.
	 * @return always returns false. 
     */
	public boolean evaluate(boolean a, boolean b){
		return false;
	}
	
	/**
     * This method prints the truth table of the Gate.
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
     */
	public void table(){
		boolean first;
		boolean second;
		int evaluated;
		System.out.println("[ A | B | Y = A " + this.symbol + " B ]");
		for (int n = 0; n < 2; n++) {
			for (int i = 0; i < 2; i++) {
				first = false;
				if (n == 1) first = true;
				second = false;
				if (i == 1) second = true;
				evaluated = 0;
				if (this.evaluate(first, second)) evaluated = 1;
				System.out.println("[ " + n + " | " + i + " |     "
				+ evaluated + "     ]");
			}
		}
		System.out.println("");
	}
}