/**
 * This class implements a Not Gate.
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 April 30
 */
public class NotGate extends Gate {
	
	/**
     * Constructor for NotGate,
	 * Also sets the corresponding symbol of the gate.
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
     */
	public NotGate(){
		symbol = "¬";
	}
	
	/**
     * This method implements the logic of the Not Gate.
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param a the first boolean.
	 * @param b the second boolean, that will be ignored.
	 * @return logical not of a.
     */
	public boolean evaluate(boolean a, boolean b) {
		return !a;
	}
}