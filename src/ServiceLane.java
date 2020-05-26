import java.util.Arrays;

public class ServiceLane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int value: serviceLane(8, new int[][] {{0,3},{4,6},{6,7},{3,5},{0,7}}, new int[] {2, 3, 1, 2, 3, 2, 3, 3,})) {
			System.out.println(value);
		} // 1,2,3,2,1
	}
	
    // Complete the serviceLane function below.
    static int[] serviceLane(int n, int[][] cases, int[] widths) {
        int[] result = new int[cases.length]; // will hold the result array
        
        int[] tArray; // temprary array where we will put a copy of a subArray of the original, given the ranges in the cases array
        int startIndex, endIndex; // will hold the staring and ending indexes for the subArray
        for(int i=0;i<cases.length;i++) { // for each case
        	startIndex = cases[i][0];
        	endIndex = cases[i][1]+1;
        	tArray = Arrays.copyOfRange(widths, startIndex, endIndex); // defines the subArray
        	Arrays.sort(tArray); // sorts the subArray
        	result[i] = tArray[0]; // gets the smaller number (position [0])
        }
        
        return result;
    }
}
