
public class RepeatedString {
	public static void main(String[] args) {
		System.out.println(repeatedString("abcac", 10l)); // expected 4
		System.out.println(repeatedString("aba", 10l)); // expected 7
		System.out.println(repeatedString("a", 1000000000000l)); // expected 1000000000000
	}
	
	static long repeatedString(String s, long n) {
		long timesRepeated = n/s.length(); // times the string will be repeated in the "n" boundary
		int timesAInSimpleString = s.replaceAll("[^a]*", "").length(); // the times 'a' appears in the base String
		
		int leftCharsLenght = (int) (n%s.length()); // the lenght of the partial string "s" after repeated timesRepeated in the "n boundary"
		String partialString = s.substring(0, leftCharsLenght); // the partial string at the end of the "n" boundary
		
		long aS = timesAInSimpleString*timesRepeated+partialString.replaceAll("[^a]*", "").length(); // the 'a's in the base string * the times the word is repeated in the "n" boundary plus the 'a's in the partial string at the end of "n"
		
		return aS;
    }
}
