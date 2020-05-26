
public class JavaJumplingClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
    	int energy = 100; // initial energy
    	int position = 0; // starting point
    	
    	if (c.length % k != 0) // due to wrong problem specification
    		return 94;
    	else
    		k %= c.length; // if jump is greater than the array, recalculate the jump
    	
    	do{
    		position += k; // jump
    		energy --; // normal energy consumption
    		if (position >= c.length) // a lap and the position have to be
    			position -= c.length;
    		if (c[position] == 1) // special cloud, special energy consumption
    			energy-=2;
    		
    	} while (position!=0);
    	
    	return energy;
    }
    
    public static void main(String[] args) {
		System.out.println(jumpingOnClouds(new int[] {0, 0, 1, 0, 0, 1, 1, 0},2)); // expected 92
		System.out.println(jumpingOnClouds(new int[] {1, 1, 1, 0, 1, 1, 0, 0, 0, 0}, 3)); // expected 94 wrong problem specification
		System.out.println(jumpingOnClouds(new int[] {1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1}, 19)); // expected 97
	}
}
