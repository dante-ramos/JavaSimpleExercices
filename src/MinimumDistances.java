import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MinimumDistances {

	public static void main(String[] args) {
		System.out.println(minimumDistances(new int[] {3,2,1,2,3})); // expected 2
		System.err.println(minimumDistances(new int[] {7, 1, 3, 4, 1, 7})); // expected 3

	}
	
    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
    	int minimumDistance = -1; // will hold the minimal distance found, the default value is -1 for the cases when no pair of numbers would be found
    	
    	// get an ordered list of the elements of a so that we know how many same numbers to search
    	LinkedList<Integer> ordered = arrToList(a); // it's a list because we want to delete the number that we are using as base, so the next time we find the same number it doesn't considere the first baseNumber as 1 time to find
    	
    	// variables for the next block of code
    	int numberToFind; // will hold the base number
    	int timesToFind; // will be calculated with the ordered list
    	int pivot; // will walk the array looking for the numberToFind just if timesToFind is greater than 0
    	for(int i=0;i<a.length-1;i++) { // get each number until the penultimate number, it have no sense to run when i is pointing to the last number
    		numberToFind = a[i];
    		pivot = i+1; // sets the pivot to one position forward the i index
    		timesToFind = calculateTimesToFind(ordered, numberToFind); // gets the occurrences of the number in the order list -1
    		ordered.remove(ordered.indexOf(numberToFind)); // removes the number just once, in order to not to consider duplicate times one number (the numberToFind would be the second of the only pair of that number)
    		if(timesToFind>0) {
    			while(numberToFind != a[pivot]) { // pivot walks until the number is found
    				pivot++;
    			}
    			if (minimumDistance==-1 || // if is the first pair found OR
    					(minimumDistance>0 && pivot-i < minimumDistance) ) { // it's not the firt pair, and the distance is less than the recorded as smaller distance
					minimumDistance = pivot-i;
				}
    		}
    	}
    	
    	return minimumDistance;
    }
    
    // calculate the times to find a number
    static int calculateTimesToFind(List<Integer> list, int number) {
    	int firstIndex = list.indexOf(number);
    	int lastIndex = list.lastIndexOf(number);
    	return lastIndex==0 ? 0 : lastIndex - firstIndex;
    }
    
    // convert an array to a sorted list
    static LinkedList<Integer> arrToList(int[] arr){
    	LinkedList<Integer> result = new LinkedList<>();
    	for(int number : arr)
    		result.add(number);
    	Collections.sort(result);
    	return result;
    }
}
