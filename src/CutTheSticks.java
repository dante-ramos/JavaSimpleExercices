import java.util.Arrays;
import java.util.LinkedList;

public class CutTheSticks {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(cutTheSticks(new int[] {1,2,3})));
		System.out.println(Arrays.toString(cutTheSticks(new int[] {5, 4, 4, 2, 2, 8})));
		System.out.println(Arrays.toString(cutTheSticks(new int[] {1, 2, 3, 4, 3, 3, 2, 1})));
//		System.out.println(cutTheSticks(new int[] {1,2,3}));
	}
	static int[] cutTheSticks(int[] arr) {
		if (arr.length==1) return new int[] {1}; // if there's only one number

		int[] intResult; // will hold the resultant array
		LinkedList<Integer> resultList = new LinkedList<Integer>(); // as we don't know how many results will be
		Arrays.sort(arr); // sorts the input array to have all the equal numbers together
		
		int currentBaseNumber = arr[0]; // will hold the first number of a series of occurrences 
		int occurrences = 1; // will hold the same numbers count
		for (int i=1;i<arr.length;i++) {
			if (arr[i]==currentBaseNumber) { // if is part of a sequence of numbers increase the count of the sequence
				occurrences++;
			}
			else { // else is the starting of a next sequence of equal numbers
				resultList.add(occurrences+arr.length-i); // add the size of the sequence and the count of the rest of numbers (whose are higher)
				occurrences = 1;
				currentBaseNumber = arr[i];
			} 
			if(i==arr.length-1) // if it's the last number in the array add the ocurrences to the result array
			resultList.add(occurrences);
		}
		
		intResult = new int[resultList.size()]; // pass the result from the linkedList to the int array
		for (int i=0;i<resultList.size();i++)
			intResult[i] = resultList.get(i);
		return intResult;
    }
}
