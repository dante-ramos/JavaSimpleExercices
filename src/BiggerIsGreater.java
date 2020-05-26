import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BiggerIsGreater {

	public static void main(String[] args) {
//		System.out.println(biggerIsGreater("abcd")); // expected abdc
//		System.out.println(biggerIsGreater("ab")); // ba
//		System.out.println(biggerIsGreater("bb") ); // no answer
//		System.out.println(biggerIsGreater("hefg")); // hegf
//		System.out.println(biggerIsGreater("dhck")); // dhkc
//		System.out.println(biggerIsGreater("dkhc")); // hcdk
//		System.out.println(biggerIsGreater("lmno")); // lmon
//		System.out.println(biggerIsGreater("dcba")); // no answer
//		System.out.println(biggerIsGreater("dcbb")); // no answer
//		System.out.println(biggerIsGreater("abdc")); // acbd
//		System.out.println(biggerIsGreater("gedcbabcd")); // gedcbabdc
		System.out.println(biggerIsGreater("abcdd")); // abdcd
	}
	
    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
    	StringBuilder result = new StringBuilder(); // will hold the result
    	char[] weights = getOrderedCharArray(w); // holds an ordered char array of the unrepeated letters of the input, the weights are the indexes
    	
    	// for to check letter by letter any sign of a greater string possible
    	// has an implicit return, if that return doesn't execute, the method will return "no answer"
    	for(int i = w.length()-2;i>=0;i--) { // backwards compairing pairs the penultimate to the last one and so on
    		if(w.charAt(i)<w.charAt(i+1)) { // if the penultimate is smaler than the last
    			result.append(w.substring(0, i)); // gets the letters that will remain unchanged (the ones at the left from the pair evaluated)
    			weights = getOrderedCharArray(w.substring(i,w.length())); // update the weights only with the letters from the pair evaluated and the letters at the right of them
    			result.append(getNextBigLetter(w.charAt(i), weights)); // append the next greater letter
    			result.append(getOrderedStringExcepting(w.substring(i,w.length()),result.charAt(result.length()-1))); // append the ordered rest of letters (other than the letter attached in the step above)
    			return result.toString();
    		}
    	}
    	
    	return "no answer";
    }
    
    // returns an ordered char array, based on the input String, eliminate duplicates (it may be used as a weight array where indexes are the weights)
    static char[] getOrderedCharArray(String w) {
    	List<Character> resultList = new LinkedList<>(); // uses a list because of the variable size given a string with duplicated letters
    	
    	for(char letter : w.toCharArray()) // adds letters without dupplicates
    		if(!resultList.contains(letter))
    			resultList.add(letter);
    	
    	Collections.sort(resultList); // sorts the list
    	
    	char[] result = new char[resultList.size()]; // will hold the resulting array, declared here because now we know the size of the result
    	for(int i=0;i<resultList.size();i++) {
    		result[i] = resultList.get(i); 
    	}
    	
    	return result;
    }
    
    // returns the next bigger letter given a charArray with the ordered chars
    static char getNextBigLetter(char currentLetter, char[] weightsArray) {
    	int currentLetterWeight = Arrays.binarySearch(weightsArray, currentLetter); // looks for the currentLetter
    	return weightsArray[currentLetterWeight+1]; // returns the next letter;
    }
    
    // returns an ordered String without one specific character
    static String getOrderedStringExcepting(String input, char excepting) {
    	boolean alreadyDeletedOne = false;
    	StringBuilder result = new StringBuilder();
    	char[] inputCharArray = input.toCharArray();
    	Arrays.sort(inputCharArray);
    	
    	for(char letter : inputCharArray) {
    		if(alreadyDeletedOne==false && letter==excepting)
    			alreadyDeletedOne=true;    			
    		else
    			result.append(letter);
    		
    	}
    	
    	return result.toString();
    }
}
