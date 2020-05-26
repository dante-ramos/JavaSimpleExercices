public class FindPairsArray {
	public static void main(String[] args) {
		System.out.println(sockMerchant(9, new int[] {10, 20, 20, 10, 10, 30, 50, 10, 20}));
	}
	
	static int sockMerchant(int n, int[] ar) {
		int pairs=0;// will count the pairs
		for (int i=0; i<n-1; i++) { // each
			if (ar[i]==-1) { // if already is a pair, go try next element
				continue;
			}
			for (int j=i+1; j<n; j++) {
				if (ar[j]==-1) // if already is a pair, go try next element 
					continue;
				if (ar[i]==ar[j]) { // if is pair, add 1 to pairs and mark the values as paired (with -1)
					pairs++;
					ar[i]=-1;
					ar[j]=-1;
					continue;
				}
			}
		}
		return pairs;
    }
}
