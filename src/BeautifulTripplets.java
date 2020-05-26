
public class BeautifulTripplets {

	public static void main(String[] args) {
		System.out.println(beautifulTriplets(1, new int[] {2,2,3,4,5})); // expected 3
		System.out.println(beautifulTriplets(3, new int[] {1, 2, 4, 5, 7, 8, 10})); // expected 3
	}

    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {
        int countOfBeautTrip = 0; // will hold the count of beautiful triplets
        
        int numberToFind; // will hold the number to find and will change if is the second number or third of the triplet
        boolean foundOne; // flat to distinguish if we find a second or third number of a beautiful triplet 
        for(int i=0;i<arr.length-2;i++) { // whill make the calculation until the antepenultimate number
        	foundOne = false; // flag to false each new base number
        	numberToFind = arr[i]+d; // number to find starts from the base number + the d increment
        	for(int j = i+1;j<arr.length;j++) { // from the next number to int til the end
        		if(arr[j]==numberToFind) { // if we find one of the triplet's numbers
        			if(foundOne==true) { // if we already have found one of the tiplet's number, this would be the third number
        				countOfBeautTrip++; // counts as a beautiful triplet and quits the inner bucle
        				break;
        			} else { // if it's the first triplet's number, this would be the second number of the triplet
        				foundOne = true; // change flag to true
        				numberToFind+=d; // make the numberToFind as baseNumber + (2*d increment)
        			}
        		}
        	}
        }
        return countOfBeautTrip;
    }
}
