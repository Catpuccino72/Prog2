class Encryption {
		
	public static int nextInt(int a, int b, int m, int x) {
		return (a*x + b) % m;
	}
	
	public static void printCharArray(char[] letters) {
		for(int n = 0; n < letters.length; n++) {
			System.out.print(letters[n]);
		}
		System.out.print("\n");
	}
	
	public static int[] encrypt(char[] letters, int[] keys) {
		int[] encrypted = new int[letters.length];
		
		for (int n = 0; n < letters.length; n++) {
			encrypted[n] = letters[n] ^ keys[n];
			//System.out.print("key[" + n +"] = " + keys[n] + " encrypted letter: "+ encrypted[n] +"\n" );
		}
		return encrypted;
	}
	
	public static char[] decrypt(int[] letters, int[] keys) {
		char[] decrypted = new char[letters.length];
		
		for (int n = 0; n < letters.length; n++) {
			decrypted[n] = (char) (letters[n] ^ keys[n]);
		}
		return decrypted;
	}
	
	public static void main(String[] args) {
		int n = 3;
		int a = 7;
		int b = 28;
		int m = 256;
		
		//initialize keys
		int[] keys = new int[5];
		for (int i = 0; i < keys.length; i++) {
			keys[i] = n;
			n = nextInt(a, b, m, n);
		}
		
		char[] letters = {'H','A','L','L','O'};
		printCharArray(letters);
		
		//encrypt and then print decrypted
		int[] encrypted_letters = new int[letters.length];
		encrypted_letters = encrypt(letters, keys);
		printCharArray(decrypt(encrypted_letters, keys));
		
	}
}