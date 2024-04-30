/**
 * This class implements an Or Gate.
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 April 30
 */
public class OrGate extends Gate {
	
	/**
     * Constructor for OrGate,
	 * Also sets the corresponding symbol of the gate.
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
     */
	public OrGate(){
		symbol = "∨";
	}

	/**
     * This method implements the logic of the Or Gate.
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param a the first boolean.
	 * @param b the second boolean.
	 * @return logical or of a and b. 
     */
	public boolean evaluate(boolean a, boolean b) {
		return (a || b);
	}
}