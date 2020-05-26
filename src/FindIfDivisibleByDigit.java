
public class FindIfDivisibleByDigit {

    // Complete the findDigits function below.
    static int findDigits(int n) {
    	int totalDivisors = 0;
    	String[] digits = Integer.toString(n).split("");
    	int digit;
    	for (String digitString : digits) {
    		digit = Integer.parseInt(digitString);
    		if (digit!=0)
    			if (n%digit == 0)
    				totalDivisors++;
    	}
    	return totalDivisors;
    }
	
	public static void main(String[] args) {
		System.out.println(findDigits(12)); // expected 2
		System.out.println(findDigits(1012)); // expected 3
	}

}
