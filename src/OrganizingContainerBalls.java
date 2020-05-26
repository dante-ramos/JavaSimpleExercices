import java.util.LinkedList;
import java.util.List;

public class OrganizingContainerBalls {

	public static void main(String[] args) {
		System.out.println(organizingContainers(new int[][]{{1,1},{1,1}})); // expected Possible
		System.out.println(organizingContainers(new int[][] {{0,2},{1,1}})); // expected Impossible
		System.out.println(organizingContainers(new int[][] {{1,3,1},{2,1,2},{3,3,3}})); // expected Impossible
		System.out.println(organizingContainers(new int[][] {{0,2,1},{1,1,1},{2,0,0}})); // expected Possible
	}
	
    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
    	
    	// To solve the problem, there should be a couple of each container size with the sum of the balls of a kind
    	
    	// Define variables
    		// temporals
    	int tempSum; // holds temporal sums per row or column
    		// not temporals
    	int len = container[0].length; // holds the lenght of each row or collumn, is used for bucles
    	List<Integer> sumsH = new LinkedList<>(); // will hold the sums per row, is a list to remove elements when a sum of column is found in it
    	
    	// get the sums per row
    	for (int i=0; i<len;i++) {
    		tempSum=0;
    		for (int data : container[i]) {
    			tempSum+=data;
    		}
    		sumsH.add(tempSum); // adds the sum to the list of sums
    	}
    	
    	// gets the sums per collumn and search an occurrence in the sumsH, if it isn't found then returns "Impossible"
    	for (int i=0; i<len;i++) {
    		// get the sum of column
    		tempSum =0;
    		for (int j=0; j<len;j++) {
    			tempSum+=container[j][i];
    		}
    		// looks if the sum is present in the sumsH
    		if(sumsH.contains(tempSum)) {
    			sumsH.remove(sumsH.indexOf(tempSum));
    		} else {
    			return "Impossible"; // if don't find the sum in the sumsH, return "Impossible"
    		}
    	}
    	
    	// if the last bucle don't return "Impossible" then return "Possible"
    	return "Possible";
    }
}
