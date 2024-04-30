/**
 * This class implements a half adder.
 * 
 * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
 * @version 2024 April 30
 */
public class HalfAdder {
	/** Xor gate */
	XorGate xg = new XorGate();
	/** And gate */
	AndGate ag = new AndGate();
	/** Gate array that saves the used gates */
	public Gate[] gates_arr = {xg, ag};
	
	/**
     * This method implements the logic of the half adder.
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
	 * @param a the first boolean.
	 * @param b the second boolean.
	 * @return a boolean array where the first element is the sum and the second the carry.
     */
	public boolean[] add(boolean a, boolean b) {
		boolean[] sum = new boolean[2];
		sum[0] = gates_arr[0].evaluate(a, b);
		sum[1] = gates_arr[1].evaluate(a, b);
		return sum;
	}
	
	/**
     * This method prints the truth tables of all the gates used.
     * 
     * @author Andreas-Daniel Lebedyuk;andreas-daniel.lebedyuk@stud.uni-hannover.de
     */
	public void info() {
		((XorGate)gates_arr[0]).table();
		((NotGate)xg.notgate).table();
		((OrGate)xg.orgate).table();
		((AndGate)gates_arr[1]).table();
	}
}