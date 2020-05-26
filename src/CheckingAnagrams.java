import java.util.Arrays;

public class CheckingAnagrams {
	static boolean isAnagram(String a, String b) {
		if (a.length()!=b.length())
			return false;
        char[] aChar = a.toLowerCase().toCharArray();
        char[] bChar = b.toLowerCase().toCharArray();
        Arrays.sort(aChar);
        Arrays.sort(bChar);
        for (int i=0; i<aChar.length-1; i++) {
        	if (aChar[i] != bChar[i])
        		return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram","margana"));
		System.out.println(isAnagram("anagramm","marganaa"));
		System.out.println(isAnagram("Hello", "hello"));
	}
}
