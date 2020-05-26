
public class NonDivisibleSubset2 {

	public static void main(String[] args) {
		System.out.println(nonDivisibleSubset(4, new int[] {19,10,12,10,24,25,22})); // exp 3
		System.out.println(nonDivisibleSubset(3, new int[] {1,7,2,4})); // exp 3
		System.out.println(nonDivisibleSubset(7, new int[] {278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436})); // expected 11
		System.out.println(nonDivisibleSubset(1, new int[] {1, 2, 3, 4, 5})); // exp 1
		System.out.println(nonDivisibleSubset(2, new int[] {393747918, 324124613, 189320024, 478345355, 164568889, 97846928, 126785644, 375502656, 411662631})); // exp 2
	}

	static int nonDivisibleSubset(int k, int[] S) {
		
		int[] modules = getModulesCount(k, S); // gets an array of counts per module for each number in S against k (how many 0 modules, how many 1 modules ...)
		
		int maxLenght=modules[0]>0 ? 1 : 0; // if there's at least 1 module 0, counts as 1 (because two ceros cant be considered for the result)
		int limit = k%2==0 ? k/2 : k/2+1; // Establishes the limit of the for loop (if pair loop goest from 1 to the half-1, else the loop goes from 1 to the half[remember that an odd int/2 = floor of the half, example 5/2 = 2])
		
		if (k%2==0 && modules[k/2]>0) // if k is even and there's at least 1 module = k/2 counts as 1, because two halfs are divisible with k
			maxLenght++;
		
		for (int i=1;i<limit;i++)  // from one to limit, gets the greatest count and adds it to the maxLenght
			maxLenght+= modules[i]>modules[k-i] ? modules[i] : modules[k-i];
		
		return maxLenght;
    }
	
	static int[] getModulesCount(int baseNumber, int[] input) {
		int[] result = new int[baseNumber];
		int module = 0; // just to initialize the variable
		for (int number: input) { // for each number in the input array
			module = number%baseNumber; // holds the module of each number in the input
			result[module] = result[module]+1; // adds each module to the rest of the same modules
		}
		return result;
	}
}
