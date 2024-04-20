class Debug { // class falsch geschrieben (ckass)
    // Methode that checks whether a given number is prime
    public static boolean isPrime(int n) {
        // Return false if number is one, zero or negative
        if (n < 2) { // n <= 2 anstelle von n < 2 verwendet
            return false; 
        }
        // Check for all factors smaller and equal to n/2 whether it is a prime factor.
        // If it is a prime factor, return false.
        for (int i = 2; i <= n / 2; i++) { // i-- anstelle von i++
            if (n % i == 0) {
                return false; // true anstelle von false verwendet
            }
        }
        // If no prime factor was found, return true.
        return true;
    }


    // Method that prints all numbers in an array that are prime
    public static void printPrime(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // i <= arr.length anstelle von i < arr.length verwendet
            if (isPrime(arr[i])) {
                System.out.println(arr[i]);
            }
        }
    }
	
	public static void main(String[] args) { // main-Methode fehlte
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		printPrime(arr);
	} 

    // output should be as follows:
    // 2
    // 3
    // 5
    // 7
}

/*
Zeile 1: class Keyword falsch geschrieben (ckass):
Fehlermeldung:
**************
Debug.java:1: error: class , interface , or enum expected
public ckass Debug {
^
**************
Der Compiler erwartet eines der drei oben angegebenen Keywords , hat aber nur das falsch
geschriebene ckass bekommen.
*/

/*
Zeile 30: Die main-Methode fehlt. Die Initialisierung des Integer Arrays "arr" 
und der Funktionsaufruf "printPrime(arr)" finden außerhalb der main-Methode statt.
Fehlermeldung:
**************
Debug_template.java:30: error: invalid method declaration; return type required
    printPrime(arr);
    ^
Debug_template.java:30: error: <identifier> expected
    printPrime(arr);
                  ^
2 errors
**************
Der Compiler interpretiert die Zeilen als syntaktisch fehlerhafte Methoden-Deklaration, 
da Funktionsaufrufe und Initialisierungen nur innerhalb von Methoden stattfinden können.
*/

/*
Zeile 22: hier wurde der Vergleichsoperator "<=" verwendet, 
jedoch hat ein Array mit der Länge n keinen Index n, sondern höchstens n-1.
**************
3
4
5
6
7
8
9
10
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
        at Debug.printPrime(Debug_template.java:23)
        at Debug.main(Debug_template.java:31)
**************
Beim Ausführen versucht das Programm, auf einen nicht vorhandenen Index des Arrays zuzugreifen.
*/

/* 
Zeile 12: hier wurde der falsche Wahrheitswert zurrückgegeben, falls der Rest der Division gleich 0 ist.
In diesem Fall ist die Zahl keine Primzahl, es müsste also false zurückgegeben werden.
*/

/*
Zeile 10: am Ende der for-Schleife wird die Laufvariable dekrementiert, 
obwohl eine Prüfung ab dem Wert 2 aufwärts stattfinden müsste.
*/

/*
Zeile 5: Vergleichsoperator "<=" anstelle von "<" verwendet. 
Primzahlen beginnen bereits ab 2 (inklusive), welche dadurch ausgeschlossen wurde.
*/
