public class Gate {
	
	public String symbol = " ";
	
	public boolean evaluate(boolean a, boolean b){
		return false;
	}
	
	public void table(){
		boolean first;
		boolean second;
		int evaluated;
		System.out.println("[ A | B | Y = A " + this.symbol + " B ]");
		for (int n = 0; n < 2; n++) {
			for (int i = 0; i < 2; i++) {
				first = false;
				if (n == 1) first = true;
				second = false;
				if (i == 1) second = true;
				evaluated = 0;
				if (this.evaluate(first, second)) evaluated = 1;
				System.out.println("[ " + n + " | " + i + " |     "
				+ evaluated + "     ]");
			}
		}
		System.out.println("");
	}
}