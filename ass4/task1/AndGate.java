/**
 * This class implements an And Gate.
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 April 30
 */
public class AndGate extends Gate {
	
	/**
     * Constructor for AndGate,
	 * Also sets the corresponding symbol of the gate.
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
     */
	public AndGate(){
		symbol = "∧";
	}

	/**
     * This method implements the logic of the And Gate.
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param a the first boolean.
	 * @param b the second boolean.
	 * @return logical and of a and b. 
     */
	public boolean evaluate(boolean a, boolean b) {
		return (a && b);
	}
}