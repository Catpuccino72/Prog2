public class Main {
	public static void main (String[] args) {
		System.out.print("Geben Sie den ersten boolean Wert an: ");
		boolean first = new java.util.Scanner(System.in).nextBoolean();
		
		System.out.print("Geben Sie den zweiten boolean Wert an: ");
		boolean second = new java.util.Scanner(System.in).nextBoolean();
		
		HalfAdder ha = new HalfAdder();
		boolean[] output = ha.add(first, second);
		int a = 0;
		int b = 0;
		if (output[0]) a = 1;
		if (output[1]) b = 1;

		System.out.printf("Die Summe lautet: %d, der Übertrag beträgt: %d\n", a, b);
		ha.info();
	}
}