public class SherlokAndSquares {

	public static void main(String[] args) {
		System.out.println(squares(3, 9)); // expected 2
		System.out.println(squares(17, 24)); // expected 0
		System.out.println(squares(100, 1000));
	}
	
    static int squares(int a, int b) {
    	int squares = 0; // keep the count of sqaures
    	// gets the first squarebase, i. e. if a = 6 squareBase will be 2 in order to evaluate the squares from 3 to b
    	int squareBase = (int) Math.sqrt(a-1) + 1; // sqrt(a-1) ensures that if a is a square it will be counted in the following bucle
    	int square = squareBase*squareBase;
    	while (square<=b){
    		squares++;
    		squareBase++;
    		square = squareBase*squareBase;
    	}
    	return squares;
    }
}
