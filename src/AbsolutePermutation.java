///https://www.hackerrank.com/challenges/absolute-permutation/problem
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AbsolutePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(absolutePermutation(5,0)));
		System.out.println(Arrays.toString(absolutePermutation(2,1)));
		System.out.println(Arrays.toString(absolutePermutation(4,1)));
		System.out.println(Arrays.toString(absolutePermutation(5,2)));
		System.out.println(Arrays.toString(absolutePermutation(10,1)));
	}
	
	static int[] absolutePermutation(int n, int k) {
		int[] ret = new int[n]; // result array
		int pos = 0; // will walk all the positions for result array
		
		int[] failArr = new int[] {-1}; // failure array result
		Set<Integer> available = new HashSet<Integer>(); // set of available numbers for result array, starts fill of index numbers (from 1) [is faster to search in a set than in an array]
		
		int plusk, minusk; // lower and greater possible number for position
		boolean plusKValid, minusKValid; // validity of plusk and minusk
		boolean plusKAlreadySure , minusKAlreadySure; // availability of plusk and minusk given it's availability in set
		
		// fill set with straight indexes
		for(int i=1;i<=n;i++)
			available.add(i);
		
		// if k == 0 permutation is same ordered array
		if(k==0)
		{
			return available.stream().mapToInt(x -> x.intValue()).toArray();
//			for(int i=1;i<=n;i++)
//                ret[i-1]=i;
		}
		
		// first round of forSure numbers
		while(pos < n)
		{
			if(ret[pos] != 0)
				break;
			// calc forSure or prov number front
			plusk = pos + 1 + k;
			plusKValid = plusk <= n;
			plusKAlreadySure = !available.contains(plusk);
			minusk = pos + 1 - k;
			minusKValid = minusk > 0;
			minusKAlreadySure = !available.contains(minusk);
			if(minusKValid && plusKValid) // if both are in range
			{
				if(minusKAlreadySure && plusKAlreadySure) // both already forSure numbers
					return failArr;
				else if(minusKAlreadySure || plusk == n)
				{
					ret[pos] = plusk;
					available.remove(plusk);
				}
				else // else use the lower number there won't be another chance to use it 
				{
					ret[pos] = minusk;
					available.remove(minusk);
				}
					
			}
			else if(minusKValid) // only minusK is in range
			{
				if(minusKAlreadySure)
					return failArr;
				ret[pos] = minusk;
				available.remove(minusk);
			}
			else if(plusKValid) // only plusk is in range
			{
				if(plusKAlreadySure)
					return failArr;
				ret[pos] = plusk;
				available.remove(plusk);
			}
			else
				return failArr;
			
			pos++; // next field
		}		
		return ret;
    }
}
