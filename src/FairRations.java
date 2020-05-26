
public class FairRations {
	public static void main(String[] args) {
		System.out.println(fairRations(new int[] {2, 3, 4, 5, 6})); // 4
		System.out.println(fairRations(new int[] {1, 2})); // NO
	}
	
    // Complete the fairRations function below.
    static int fairRations(int[] B) {
    	int breads = 0; // will hold the count of breads handed to the subjects
    	
    	for(int i=0;i<B.length-1;i++) { // as giving one bread to one person needs to give one to the next person, this buble check if one person has even number of breads and if it doesn't the gives one to it and one to the next person, so the cicle ends with the penultimate person
    		if(B[i]%2.0 != 0) { // even breads?
    			breads+=2;
    			B[i+1] = B[i+1] + 1;
    		}    			
    	}
    	
    	if(B[B.length-1]%2.0 != 0) // if the last person doesn't have even number of breads
    		return -1; // so the hackerRank page count it as a "NO"
    	
    	return breads;
    }
}
