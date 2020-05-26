
public class StringCompareDemo {
	public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
		for (int i=0;i<k;i++) // defining the biggest string possible in order to correctly compare other strings
        	smallest+="z";
        String largest = "";
        
        String temporalSubstring;
        
        for (int i=0;i<s.length()-k+1;i++) {
        	temporalSubstring = s.substring(i, i+k);
        	smallest = smallest.compareTo(temporalSubstring)>0 ? temporalSubstring : smallest; // if temporalSubstring is greater
        	largest = largest.compareTo(temporalSubstring)<0 ? temporalSubstring : largest; // if temporalSubstring is smaller
        }
        
        return smallest + "\n" + largest;
    }
	public static void main(String[] args) {
		System.out.println("Resultado: " + getSmallestAndLargest("welcometojava", 3));
	}
}
