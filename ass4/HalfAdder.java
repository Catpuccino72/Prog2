public class HalfAdder {
	XorGate xg = new XorGate();
	AndGate ag = new AndGate();
	public Gate[] gates_arr = {xg, ag};
	
	public boolean[] add(boolean a, boolean b) {
		boolean[] sum = new boolean[2];
		sum[0] = gates_arr[0].evaluate(a, b);
		sum[1] = gates_arr[1].evaluate(a, b);
		return sum;
	}
	
	public void info() {
		((XorGate)gates_arr[0]).table();
		((NotGate)xg.notgate).table();
		((OrGate)xg.orgate).table();
		((AndGate)gates_arr[1]).table();
	}
}