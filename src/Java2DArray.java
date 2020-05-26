import java.util.Scanner;

public class Java2DArray {

	static final Scanner scanner = new Scanner (System.in);
	
	public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        scanner.close();
  
        int maxSum = 0;
        int currentHourGlassSum;
        for (int i=0;i<4;i++) {
        	for (int j=0; j<4; j++) {
        		currentHourGlassSum = 0;
        		for (int k=i;k<i+3;k++) {
        			currentHourGlassSum+=arr[k][j] + arr[k][j+2];
        			if (k == i+1) {
        				currentHourGlassSum += arr[k][k];
        			}
        		}
        		maxSum = Math.max(maxSum, currentHourGlassSum);
        	}
        }
        System.out.println(maxSum);
    }
}
