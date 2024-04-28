public class Gate {
	
	private String symbol;
	
	public boolean evaluate(boolean a, boolean b){
		return false;
	}
	
	public void table(){
		boolean first;
		boolean second;
		System.out.println("[ A | B | Y = A " + symbol + " B]");
		for (int n = 0; n < 2; n++) {
			for (int i = 0; i < 2; i++) {
				boolean first = false;
				if (n == 1) first = true;
				boolean second = false;
				if (i == 1) second = true;
				System.out.println("[ " + n + " | " + i + " | "
				+ this.evaluate(first, second) + " ]";
			}
		}
	}
}