
public class DivSumPairs {
	static int divisibleSumPairs(int n, int k, int[] ar) {
		int pairs =0;
		for (int i=0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) {
				System.out.println(ar[i] + " y " + ar[j] + " con " + k);
				if((ar[i]+ar[j])%(float)k == 0.0) {
					pairs++;
					continue;
				}
			}
		}
		return pairs;
    }
	
	public static void main(String[] args) {
		System.out.println(divisibleSumPairs(6, 5, new int[] {1,2,3,4,5,6}));
		System.out.println(divisibleSumPairs(6, 3, new int[] {1, 3, 2, 6, 1, 2}));
	}
}
