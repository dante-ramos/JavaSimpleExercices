///https://www.hackerrank.com/challenges/3d-surface-area/problem
public class ThreeDSurfaceArea {

	public static void main(String[] args) {
		//System.out.println(surfaceArea(new int[][] {{1,3,4},{2,2,3},{1,2,4}})); // expected 60
		System.out.println(surfaceArea(new int[][] {{51,32,28,49,28,21,98,56,99,77}} ));
	}

	static int surfaceArea(int[][] A) {
		int h = A.length; 
		int w = A[0].length;
		int surface = h * w * 2; // equals to size of board * 2 because there will be one floor and one top for each number in the array, only eight will vary
		int curN, upN, downN, leftN, rightN;
		
		for(int i=0 ; i<h ; i++)
		{
			for(int j=0 ; j<w ; j++)
			{
				curN = A[i][j];
				
				// evaluate left
				if(i==0) // there's no left
					surface += curN;
				else // there's a left number
				{
					leftN = A[i-1][j];
					surface += curN > leftN ? Math.abs(curN - leftN) : 0;
				}
				
				//evaluate right
				if(i==h-1) // there's no right
					surface += curN;
				else 
				{
					rightN = A[i+1][j];
					surface += curN > rightN ? Math.abs(curN - rightN) : 0;
				}

				// evaluate top
				if(j==0) // there's no top number
					surface += curN;
				else
				{
					upN = A[i][j-1];
					surface +=  curN > upN ? Math.abs(curN - upN) : 0;
				}
				
				// evaluate bottom
				if(j==w-1) // there's no bottom number
					surface += curN;
				else
				{
					downN = A[i][j+1];
					surface += curN > downN ? Math.abs(curN - downN) : 0;
				}
			}
		}
		
		return surface;
    }
}
