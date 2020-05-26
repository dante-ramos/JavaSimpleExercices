///https://www.hackerrank.com/challenges/acm-icpc-team/problem
import java.util.BitSet;

public class ACP_ICPC_Team3 {
	public static void main(String[] args) {
		for(int result:acmTeam(new String[] {"10101", "11100", "11010", "00101"})) {
			System.out.println(result); // expected 5 and 2
		}
	}
	
	static int[] acmTeam(String[] topic) {
        int maxSum = 0, countOfMax=0;
        int sumOfPair;
        
        for(int i=0;i<topic.length-1;i++)
            for(int j=i+1;j<topic.length;j++) {
            	sumOfPair = stringToBitSet(topic[i],topic[j]).cardinality();
            	if(sumOfPair==maxSum)
            		countOfMax++;
            	else if(sumOfPair>maxSum) {
            		maxSum = sumOfPair;
            		countOfMax = 1;
            	}
            }
        return new int[] {maxSum,countOfMax};
    }
	
	static BitSet stringToBitSet(String bin1, String bin2) {
		int len = bin1.length();
		BitSet bitset = new BitSet();
	    for (int i = len-1; i >= 0; i--) {
	        if (bin1.charAt(i) == '1' || bin2.charAt(i) == '1') {
	            bitset.set(len-i-1);
	        }
	    }
	    return bitset;
	}
}
