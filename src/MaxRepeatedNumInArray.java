import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaxRepeatedNumInArray {
	
	static int migratoryBirdsString(List<Integer> arr) {
		Collections.sort(arr);
		String input = arr.toString();
		int times1 = getTimes(input, "1");
		input = input.substring(input.lastIndexOf("1")+1);
		int times2 = getTimes(input, "2");
		input = input.substring(input.lastIndexOf("2")+1);
		int times3 = getTimes(input, "3");
		input = input.substring(input.lastIndexOf("3")+1);
		int times4 = getTimes(input, "4");
		input = input.substring(input.lastIndexOf("4")+1);
		int times5 = getTimes(input, "5");
		input = input.substring(input.lastIndexOf("5")+1);

		return getTheMax(times1, times2, times3, times4, times5);
    }
	
	private static int getTimes (String s, String number) {
		return s.substring(s.indexOf(number), s.lastIndexOf(number)+1).length();
	}
	
	private static int getTheMax(int times1, int times2, int times3, int times4, int times5) {
		int maxNumberTimes = times1;
		int maxNumber =1;
		if (times2>maxNumberTimes) {
			maxNumberTimes = times2;
			maxNumber = 2;
		}
		
		if (times3>maxNumberTimes) {
			maxNumberTimes = times3;
			maxNumber = 3;
		}
		if (times4>maxNumberTimes) {
			maxNumberTimes = times4;
			maxNumber = 4;
		}
		if (times5>maxNumberTimes) {
			maxNumberTimes = times5;
			maxNumber = 5;
		}
		return maxNumber;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		List<Integer> lista = (List<Integer>) Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4);
		System.out.println(migratoryBirdsString(lista));
		
		// Test2
		Scanner scann = new Scanner(new File ("./src/MaxRepeatedNumInArray.txt"));
		String[] input = scann.nextLine().split(" ");
		lista = new ArrayList<>();
		for (String number : input) {
			lista.add(Integer.parseInt(number));
		}
		scann.close();
		System.out.println(migratoryBirdsString(lista));
	}

}
