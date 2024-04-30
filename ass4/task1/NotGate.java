public class NotGate extends Gate {
	
	public NotGate(){
		symbol = "¬";
	}
	
	public boolean evaluate(boolean a, boolean b) {
		return !a;
	}
}