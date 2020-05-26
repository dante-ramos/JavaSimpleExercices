
public class CircularRotationArray {
	static int[] circularArrayRotation(int[] a, int k, int[] queries) {
		int[] result = new int[queries.length];
		k%= a.length; // consideres a complete round of rotation to make the script faster;
		int finalPosition;
		for(int i=0;i<queries.length;i++) {
			finalPosition = queries[i]-k;
			result[i] = finalPosition >= 0 ? a[finalPosition] : a[a.length+finalPosition]; 			
		}
		return result;
    }
	
	public static void main(String[] args) {
		for (int number : circularArrayRotation(new int[] {1,2,3}, 2, new int[] {0,1,2}))
			System.out.println(number);
		System.out.println("\nNext result:");
		for (int number : circularArrayRotation(new int[] {8,7,6,8,10,2,7,3}, 10, new int[] {6}))
			System.out.println(number);
	}
}
