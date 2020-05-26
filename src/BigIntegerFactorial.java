import java.math.BigInteger;

public class BigIntegerFactorial {
    static void extraLongFactorials(int n) {
    	BigInteger result = new BigInteger(Integer.toString(n));
    	for (int i=1;i<n;i++)
    		result = result.multiply(BigInteger.valueOf(Integer.valueOf(n-i))); 
    	System.out.println(result.toString());
    }
    
    public static void main(String[] args) {
		extraLongFactorials(25); // expected 
	}
}
