public class MagicSquare {
	static final int[] archeCube = {2,7,6,1,8,3,4,9}; // contains the secuence of the 8 numbers surrounding a 5 in a cube, can be inverse, pairs in the corners

	static int formingMagicSquare(int[][] s) {
		int cost=1000000;
		int[] baseCube = null; // each magic cube for comparison
		int baseCubeCost; // difference with each magic cube
		for (int i=0;i<8;i++) {
			if (i%2!=0)
				baseCube = invertCube(baseCube);
			else
				baseCube = getCube(i);
			baseCubeCost = calculateDifference(s, baseCube, cost);
			if (baseCubeCost<cost)
				cost = baseCubeCost;
		}
		return cost;
    }
	
	static int[] getCube(int cicle){
		int[] cube = new int[9]; // starts and ends with with the upper left corner in order to reverse it in a following cicle
		int archeCubeIndex = cicle;
		for (int i=0;i<9;i++) {
			cube[i] = archeCube[archeCubeIndex];
			archeCubeIndex++;
			if (archeCubeIndex>7)
				archeCubeIndex = 0;
		}
		return cube;
	}
	static int[] invertCube(int[] originalCube) {
		int[] result = new int[9];
		for(int i=0;i<9;i++)
			result[i] = originalCube[8-i];
		return result;
	}
	
	static int calculateDifference(int[][] original, int[] newBox, int minCost) {
		int thisCost = calcAbsDif(5,original[1][1]);
		int[] flattenedBox = flatenBox(original);
		for (int i=0; i<8; i++) {
			thisCost+=calcAbsDif(flattenedBox[i], newBox[i]);
			if (thisCost>minCost)
				return minCost+1;
		}		
		return thisCost;
	}
	
	static int[] flatenBox(int[][] original) {
		int[] result = new int[8];
		for(int i=0;i<8;i++) {
			if(i<3)
				result[i] = original[0][i];
			else if(i<5)
				result[i] = original [i-2][2];
			else if(i<7)
				result[i] = original[2][6-i];
			else 
				result[i] = original[1][0];
		}
		return result;
	}
	
	static int calcAbsDif(int a, int b) {
		return Math.abs(Math.abs(a) - Math.abs(b));
	}
	
	public static void main(String[] args) {
		System.out.println(formingMagicSquare(new int[][]{{4,9,2},{3,5,7},{8,1,5}}));
		System.out.println(formingMagicSquare(new int[][]{{4,8,2},{4,5,7},{6,1,6}}));
	}
}
