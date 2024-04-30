public class AndGate extends Gate {
	
	public AndGate(){
		symbol = "∧";
	}

	public boolean evaluate(boolean a, boolean b) {
		return (a && b);
	}
}