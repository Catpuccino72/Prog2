
public class IntList {
	
	public static int countNumbers(int num) {
		int length = 0;
		while(num > 0) {
			length++;
			num = num / 10;
		}
		return length;
	}
	
	public static int[] intToList(int value) {
		int list[] = new int[countNumbers(value)];
		
		int indeces = (countNumbers(value) - 1);
				
		for (int n = (countNumbers(value) - 1); n >= 0; n--) {
			
			// get number_to_subtract
			int number_to_subtract = 1;
			for (int i = n; i > 0; i--) {
				number_to_subtract *= 10;
			}
			
			//System.out.println("n:  " + n + " number_to_subtract: " + number_to_subtract);
			
			int number_for_index = 0;
			while(value - number_to_subtract >= 0) {
				value -= number_to_subtract;
				number_for_index++;
			}
			
			int index = indeces - n;
			
			//System.out.println("new value: " + value + " number_for_index: " + number_for_index + " index: " + index);
			
			list[index] = number_for_index;
		}
		return list;
	}
	
	public static int listToInt(int[] numbers) {
		int return_number = 0;
		int array_length = numbers.length - 1;
		int factor = 1;
		
		for (int n = array_length; n >= 0; n--) {
			return_number += numbers[n] * factor;
			factor *= 10;
		}
		
		return return_number;
	}
	
	public static int[] addOne(int[] numbers) {
		return intToList(listToInt(numbers) + 1);
	}
	
	public static void main(String[] args) {
		System.out.println(countNumbers(1));
		System.out.println(countNumbers(11));
		System.out.println(countNumbers(1000000));
		
		System.out.println(listToInt(addOne(intToList(9999))));
		System.out.println(listToInt(addOne(intToList(1234))));
		System.out.println(listToInt(addOne(intToList(22))));
	}
}