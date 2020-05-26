
public class JumpingOnTheClouds {
	
	public static void main(String[] args) {
		System.out.println(jumpingOnClouds(new int[] {0, 0, 1, 0, 0, 1, 0})); // expected 4
		System.out.println(jumpingOnClouds(new int[] {0, 0, 0, 0, 1, 0})); // expected 3
	}
	
	static int jumpingOnClouds(int[] c) {
		int jumps = 1;
		for (int i=1;i<c.length-2;i++) {
			if(c[i+1]!=1)
				i++;
			jumps++;
		}
		return jumps;
    }
}
