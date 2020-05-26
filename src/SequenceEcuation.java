
public class SequenceEcuation {
    static int[] permutationEquation(int[] p) {
    	int[] result = new int[p.length];
    	int numberToFind1; // base number like 1 or 2
    	int numberToFind2=0; // position of the index needed to point to numberToFind1; p[p[numbertoFind2]] = numberToFind1
    	for (int i=1;i<=p.length;i++) { // gets the number to be found eg: 1-5
    		numberToFind1 = i;
    		for (int j=0;j<p.length;j++) {
    			if (p[j]== numberToFind1) {
    				numberToFind2 = j+1;
    				break;    				
    			}
    		}
    		for (int j=0;j<p.length;j++) {
    			if (p[j]== numberToFind2) {
    				result[i-1] = j+1;
    				break;    				
    			}
    		}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
		for (int i: permutationEquation(new int[] {2,3,1})) System.out.println(i);
		System.out.println("\nNextResult;");
		for (int i: permutationEquation(new int[] {4,3,5,1,2})) System.out.println(i);
	}
}
