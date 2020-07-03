///https://www.hackerrank.com/challenges/strange-code/problem
public class StrangeCounters {

	public static void main(String[] args) {
		System.out.println(strangeCounter(37L));

	}

	static long strangeCounter(long t) {
		long ret;
        double exp;
        double thisFirstTime, thisFirstNum;
        
        exp = Math.log10(((double)t+2)/3)/Math.log10(2);
        if(exp%1 == 0) // first element
        {
        	ret = t + 2;
        }
        else // not first element
        {
        	thisFirstNum = Math.pow(2, Math.floor(exp)) * 3;
        	thisFirstTime = thisFirstNum - 2;
        	ret = (long) (thisFirstNum - (t - thisFirstTime));
        }
        return ret;
    }
}
