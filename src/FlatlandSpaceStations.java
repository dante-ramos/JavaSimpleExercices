import java.util.Arrays;

public class FlatlandSpaceStations {
	public static void main(String[] args) {
		System.out.println(flatlandSpaceStations(5, new int[] {0,4})); // 2
		System.out.println(flatlandSpaceStations(6, new int[] {0,1,2,3,4,5})); // 0
		System.out.println(flatlandSpaceStations(20, new int[] {13, 1, 11, 10, 6})); // 6
	}
	
    static int flatlandSpaceStations(int n, int[] c) {
    	Arrays.sort(c); // sorting the c array, to compare one number to the next one

    	int maxSpaces = c[0] == 0 ? 0 : c[0]; // special case when the first city doesn't have a station, the maxSpaces have to be c[0]
    	int currentSpaces = 0; // will hold the comparation of a couple of numbers in c array
    	if (c[c.length-1] != n) { // special case when the las city doesn't have a station
    		currentSpaces = n - c[c.length-1] - 1; // compare the end of array with the position of the last city with an station
    		maxSpaces = Math.max(currentSpaces,maxSpaces); // simple max comparation
    	}
    	
    	for(int i=0;i<c.length-1;i++) {
    		currentSpaces = (c[i+1] - c[i])/2; // compare two cities with stations positions and get the distance from the middle of the distance between them
    		maxSpaces = Math.max(currentSpaces,maxSpaces); // simple max comparation
    	}
    	
    	return maxSpaces;
    }
}
