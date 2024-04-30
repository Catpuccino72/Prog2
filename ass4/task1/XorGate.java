/**
 * This class implements a Xor Gate.
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 April 30
 */
public class XorGate extends Gate {
	/** Not Gate */
	public NotGate notgate;
	/** Or Gate */
	public OrGate orgate;
	/** And Gate */
	public AndGate andgate;
	
	/**
     * Constructor for XorGate,
	 * Also sets the corresponding symbol of the gate.
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
     */
	public XorGate() {
		notgate = new NotGate();
		orgate = new OrGate();
		andgate = new AndGate();
		this.symbol = "⊕";
	}
	
	/**
     * This method implements the logic of the Xor Gate.
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param a the first boolean.
	 * @param b the second boolean.
	 * @return logical Xor of a and b. 
     */
	public boolean evaluate(boolean a, boolean b) {
		return orgate.evaluate(andgate.evaluate(a, notgate.evaluate(b, b)),
		andgate.evaluate(notgate.evaluate(a, a), b));
	}
}