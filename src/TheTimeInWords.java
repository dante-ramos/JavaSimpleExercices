import java.util.HashMap;

public class TheTimeInWords {

	public static void main(String[] args) {
		System.out.println(timeInWords(5, 47));
		System.out.println(timeInWords(3, 00));
		System.out.println(timeInWords(7, 15));
		System.out.println(timeInWords(1, 1));
	}
	
	static HashMap<Integer,String> numbers = new HashMap<>();
	
	static {
		numbers.put(1, "one");
		numbers.put(2, "two");
		numbers.put(3, "three");
		numbers.put(4, "four");
		numbers.put(5, "five");
		numbers.put(6, "six");
		numbers.put(7, "seven");
		numbers.put(8, "eight");
		numbers.put(9, "nine");
		numbers.put(10, "ten");
		numbers.put(11, "eleven");
		numbers.put(12, "twelve");
		numbers.put(13, "thirteen");
		numbers.put(14, "thirteen");
		numbers.put(15, "quarter");
		numbers.put(16, "sixteen");
		numbers.put(17, "seventeen");
		numbers.put(18, "eighteen");
		numbers.put(19, "nineteen");
		numbers.put(20, "twenty");
		numbers.put(30, "half");
	}
	
    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
    	StringBuilder result = new StringBuilder();
    	boolean pastHalf = m>30;
    	m = pastHalf ? 60-m : m;
    	
    	if (m ==0 ) // o'clock
    		result.append(numbers.get(h) + " o' clock");
    	else { // if not o'clock
    		// first part of test
    		if (m < 21 || m==30) { // simple number 1 to 20 or 30
    			result.append(numbers.get(m));
    		} else { // composite number 21 to 29
    			result.append(numbers.get(20)+" "+numbers.get(m%10));
    		}
    		
    		// minutes or not, just if it isn't quarter or half
    		if (m%15 != 0) {
    			result.append(" minute");
    			if (m!=1)
    				result.append("s");    			
    		}
    		
    		// to or past h or h+1
    		if (pastHalf) {
    			result.append(" to " + numbers.get(h+1));    			
    		}else {
    			result.append(" past " + numbers.get(h));    			
    		}
    	}
    	return result.toString();
    }
}
