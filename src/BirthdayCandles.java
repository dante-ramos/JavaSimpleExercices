import java.util.Arrays;

public class BirthdayCandles {
	public static void main(String[] args) {
		int[] ar = {3,2,1,3};
		Arrays.sort(ar);
        String candlesString = Arrays.toString(ar);
        int size = candlesString.length();
        char highestSize = candlesString.charAt(size-1);
        System.out.println("Size "+size);
        System.out.println("Aray " + candlesString);
        System.out.println("Start char " + candlesString.indexOf(highestSize));
        System.out.println(size-candlesString.indexOf(highestSize)); 
	}
}
