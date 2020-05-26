
public class KaprekarNumbers {

	public static void main(String[] args) {
		kaprekarNumbers(65536, 70000);

	}

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
    	long square;
    	int leftNum=0, rightNum=0; // will hold the right and left parts of the square
    	int numberLen, squareLen; // will hold the length of the original number and the length of the square, so that the substrings can be calculated 
    	String squareString; // will hold the square number in a String, so that we can make substrings
    	for(int i=p;i<=q;i++) { // from p to q
    		square = (long)i*i;
    		squareString = Long.toString(square);
    		squareLen = squareString.length();
    		numberLen = Integer.toString(i).length();
    		rightNum = Integer.parseInt(squareString.substring(squareLen-numberLen, squareLen)); // right part always the have the lenght of the original number
    		if(squareLen > 1) //  if the square is not a single digit number, calculates de left part, else keeps the  value
    			leftNum = Integer.parseInt(squareString.substring(0,squareLen-numberLen));
    		if(leftNum + rightNum != i) // check the sum of the parts is equal to the original number
    			System.out.print(i + " ");
    	}

    }
	
}
