import java.math.BigInteger;
import java.util.Scanner;

public class PrimalityTest {
	
    static final Scanner scanner = new Scanner(System.in);
    
	public static void main(String[] args) {
        String n = scanner.nextLine();

        scanner.close();
        
        if (new BigInteger(n).isProbablePrime(100))
        	System.out.println("prime");
        else
        	System.out.println("not prime");
    }
}
