/// https://www.hackerrank.com/challenges/append-and-delete/problem
public class AppendAndDeleteLetters {

	public static void main(String[] args) {
		System.out.println(appendAndDelete("hackerhappy", "hackerrank", 9)); // expected yes
		System.out.println(appendAndDelete("aba", "aba", 7)); // expected yes
		System.out.println(appendAndDelete("abcdef", "fedcba", 15)); // expected yes
		System.out.println(appendAndDelete("ashley", "ash", 2)); // expected no
		System.out.println(appendAndDelete("abcd", "abcdert", 10)); // expected no
		System.out.println(appendAndDelete("asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv", "bsdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv", 100)); // expected no
	}
	
    static String appendAndDelete(String s, String t, int k) {
    	boolean foundDifferent = false;
    	int equalCharacters = 0;
    	String smallerString = s.length()<=t.length() ? s : t;
    	for (int i=0; i < smallerString.length();i++) {
    		if (s.charAt(i)!=t.charAt(i)) {
    			k -= (s.length()-i) + (t.length()-i);
    			foundDifferent = true;
    			equalCharacters = i;
    			break;
    		}
    	}
    	if (foundDifferent == false && s.length()!=t.length()) {
    		k -=Math.abs(s.length()-t.length());
    		equalCharacters = smallerString.length();
    	}
    	if (k == 0) {
            return "Yes";
        } else if (k>equalCharacters*2 || (k>0 && k%2==0))
            return "Yes";
   		return "No";
    }
}
