public class XorGate extends Gate {
	
	public NotGate notgate;
	public OrGate orgate;
	public AndGate andgate;
	
	public XorGate() {
		notgate = new NotGate();
		orgate = new OrGate();
		andgate = new AndGate();
		this.symbol = "⊕";
	}
	
	public boolean evaluate(boolean a, boolean b) {
		return orgate.evaluate(andgate.evaluate(a, notgate.evaluate(b, b)),
		andgate.evaluate(notgate.evaluate(a, a), b));
	}
}