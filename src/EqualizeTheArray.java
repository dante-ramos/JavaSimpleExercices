import java.util.Arrays;

public class EqualizeTheArray {

	public static void main(String[] args) {
		System.out.println(equalizeArray(new int[] {3, 3, 2, 1, 3}));

	}
	
	static int equalizeArray(int[] arr) {
		Arrays.sort(arr);
		int baseNumber = arr[0];
		int maxEquals = 0;
		int baseNumberEquals=1;
		
		for(int i=1;i<arr.length;i++) {
			if (arr[i]!=baseNumber){
				maxEquals = baseNumberEquals > maxEquals ? baseNumberEquals : maxEquals;
				baseNumberEquals=1;
				baseNumber = arr[i];			
			} else {
				baseNumberEquals++;
			}
		}
		maxEquals = baseNumberEquals > maxEquals ? baseNumberEquals : maxEquals;
		
		return arr.length-maxEquals;
    }
}
