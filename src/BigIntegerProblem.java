import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerProblem {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
            BigInteger number1 = new BigInteger(scanner.nextLine());
            BigInteger number2 = new BigInteger(scanner.nextLine());
        scanner.close();
        System.out.println(number1.add(number2).toString());
        System.out.println(number1.multiply(number2).toString());
    }

}
