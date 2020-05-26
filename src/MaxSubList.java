import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxSubList {

	public static int pickingNumbers(List<Integer> a) {
		Collections.sort(a);
		int maxLenght = 0;
		int number1 = a.get(0);
		int number1Ocurrences = 1;
		int number2 = number1;
		int number2Ocurrences = 0;
		for (int i = 1; i < a.size(); i++) {
			if (a.get(i) == number1)
				number1Ocurrences++;
			else if (Math.abs(number1 - a.get(i)) == 1) {
				number2 = a.get(i);
				number2Ocurrences++;
			} else if(Math.abs(number2 - a.get(i)) == 1) {
					number1 = number2;
					number1Ocurrences = number2Ocurrences;
					number2Ocurrences = 1;
					number2 = a.get(i);
			}
			else {
				number1 = a.get(i);
				number1Ocurrences = 1;
				number2Ocurrences = 0;					
			}
			if (maxLenght < number1Ocurrences + number2Ocurrences) 
				maxLenght = number1Ocurrences + number2Ocurrences;
		}
		if (number1 == number2)
			return number1Ocurrences;
		return maxLenght;
	}

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		input.addAll(Arrays.asList(4, 6, 5, 3, 3, 1));
		System.out.println(pickingNumbers(input));
		input.clear();
		input.addAll(Arrays.asList(1, 2, 2, 3, 1, 2));
		System.out.println(pickingNumbers(input));
		input.clear();
		input.addAll(Arrays.asList(14, 18, 17, 10, 9, 20, 4, 13, 19, 19, 8, 15, 15, 17, 6, 5, 15, 12, 18, 2, 18, 7, 20, 8, 2, 8, 11, 2, 16, 2, 12, 9, 3, 6, 9, 9, 13, 7, 4, 6, 19, 7, 2, 4, 3, 4, 14, 3, 4, 9, 17, 9, 4, 20, 10, 16, 12, 1, 16, 4, 15, 15, 9, 13, 6, 3, 8, 4, 7, 14, 16, 18, 20, 11, 20, 14, 20, 12, 15, 4, 5, 10, 10, 20, 11, 18, 5, 20, 13, 4, 18, 1, 14, 3, 20, 19, 14, 2, 5, 13));
		System.out.println(pickingNumbers(input));
		input.clear();
		for(int i=0; i<100; i++) {
			input.add(66);
		}
		System.out.println(pickingNumbers(input));
		input.clear();
		String myString = "84 43 11 41 2 99 31 32 56 53 42 14 98 27 64 57 16 33 48 21 46 61 87 90 28 12 62 49 29 77 82 70 80 89 95 52 13 19 9 79 35 67 51 39 7 1 66 8 17 85 71 97 34 73 75 6 91 40 96 65 37 74 20 68 23 47 76 55 24 3 30 22 55 5 69 86 54 50 10 59 15 4 36 38 83 60 72 63 78 58 88 93 45 18 94 44 92 81 25 26";
		for (String data : myString.split(" "))
			input.add(Integer.parseInt(data));
		System.out.println(pickingNumbers(input));
		input.clear();
		myString = "49, 50, 51, 52, 53, 54, 55, 55, 56, 57, 58, 59, 60, 61";
		for (String data : myString.split(", "))
			input.add(Integer.parseInt(data));
		System.out.println(pickingNumbers(input));
	}

}
