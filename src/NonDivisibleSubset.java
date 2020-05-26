import java.util.Arrays;
import java.util.LinkedList;

public class NonDivisibleSubset {

	public static void main(String[] args) {
		System.out.println(nonDivisibleSubset2(4, new int[] {19,10,12,10,24,25,22})); // exp 3
		System.out.println(nonDivisibleSubset2(3, new int[] {1,7,2,4})); // exp 3
		System.out.println(nonDivisibleSubset2(7, new int[] {278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436})); // expected 11
		System.out.println(nonDivisibleSubset2(1, new int[] {1, 2, 3, 4, 5})); // exp 1
		System.out.println(nonDivisibleSubset2(2, new int[] {393747918, 324124613, 189320024, 478345355, 164568889, 97846928, 126785644, 375502656, 411662631})); // exp 2
	}

	static int nonDivisibleSubset(int k, int[] S) {
		
		int[] modules = getModules(S, k); // the module of each element on S, only one 0, and only one k/2 if apply
		int maxLenght=1; // at least one number should be provided, so the base result is 1
		int firstCandidateIndex=0, lastCandidateIndex=modules.length-1; // starts from the edges of the array so each pair can be compared to k
		int pairSum; // the sum of each pair
		
		while (lastCandidateIndex-firstCandidateIndex!=0) { // cicle to go from the edgest to the center of the array of modules, when the indexes are 1 nest to other, the cicle finishes
			pairSum = modules[firstCandidateIndex] + modules[lastCandidateIndex]; // makes the sum
			if(pairSum != k) { // if the sum is not equals to k
				maxLenght++; 
				if(pairSum>k) // if the sum is higher or lower to k, will make the indexes move
					lastCandidateIndex--;
				else
					firstCandidateIndex++;
			}
			else if(modules[firstCandidateIndex] == modules[firstCandidateIndex+1] || modules[lastCandidateIndex]== modules[lastCandidateIndex-1]){ // if various coples that sums k are repeated over the array
				firstCandidateIndex++; // moves both of the indexes
				lastCandidateIndex--; 
				maxLenght++; // at least one of the numbers will be part of a valid couple, because of that, sums 1 to the result each repeated pair
			} else
				lastCandidateIndex--; // if the couple sums k and there's no repeated couples of modules, just move the last index
		}
		return maxLenght;
    }
	
/////////////////////// COMPLEMENTARY METHODS ////	
	
	static int[] getModules(int[] input, int baseNumber) {
		LinkedList<Integer> resultList = new LinkedList<>();
		int[] result;
		int module;
		for(int number : input) {
			module = number%baseNumber;
			if (module == 0 || module==baseNumber/2.0) // if module is 0 or the half of k
				if (resultList.contains(module)) // if already a 0 or a half of k in the modules list
					continue; // continue the cycle without adding it
			resultList.add(module); // add the module to the resultList
		}
		result = new int[resultList.size()];
		for (int i=0;i<resultList.size();i++) {
			result[i] = resultList.get(i);
		}
		Arrays.sort(result);
		return result;
	}
	
	
	
	///////////////// NON OFFICIAL METHODS ////////////
	static int nonDivisibleSubset2(int k, int[] S) {
		int result;
		int[] count = new int[k];
		for(int divisor : S)
        {
            count[divisor%k] += 1;
        }
        result = Math.min(count[0], 1);
        for(int i = 1; i < (k/2)+1; i++)
        {
            if(i != k - i)
                result += Math.max(count[i], count[k-i]);
        }
        if(k%2 == 0)
            result += 1;
        
        return result;
	} 
}
