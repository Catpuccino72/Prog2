public class OrGate extends Gate {
	
	public OrGate(){
		symbol = "∨";
	}

	public boolean evaluate(boolean a, boolean b) {
		return (a || b);
	}
}