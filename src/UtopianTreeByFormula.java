import java.io.IOException;
import java.util.Scanner;

public class UtopianTreeByFormula {
	static int utopianTree(int n) {
		if (n%2!=0)
			return (int)(Math.pow(2,(((n+1)/2)+2))/2-2);
        return (int) ((Math.pow(2,((n/2)+2))/2)-1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.println(utopianTree(n));
        }
        scanner.close();
    }
}
