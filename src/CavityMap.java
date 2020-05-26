import java.util.Arrays;

/// https://www.hackerrank.com/challenges/cavity-map/problem
/// will have 2 bidimensional arrays input with the inputed ints and holes with: 0 on positions that wont be Xs 
public class CavityMap {

	public static void main(String[] args) {
		String[] grid = {"989","191","111"};
		for(String result:cavityMap(grid))
			System.out.println(result);
		
		String[] grid2 = {"1112","1912","1892","1234"};
		for(String result:cavityMap(grid2))
			System.out.println(result);
	}

	static String[] cavityMap(String[] grid) {
		String[] 		ret;
		int[][] 		input, holes;
		
		int 			sideLen;
		String			row;	
		String[]		rowNumbers;
		
		int				current, left, right, above, below;
		
		// ;
		
		sideLen = grid.length;
		
		ret = new String[sideLen];
		
		//map the string array in a bidimensional int array, 
		//the holes array will be the same but with 0 at the borders
		input = new int[sideLen][sideLen];
		holes = new int[sideLen][sideLen];
		for(int i=0; i<sideLen ; i++){
			row = grid[i];
			rowNumbers = row.split("");
			for(int j=0;j<rowNumbers.length;j++)
				input[i][j] = holes[i][j] = Integer.parseInt(rowNumbers[j]);
		}
		
		// evaluate holes
		for(int i=1; i<sideLen-1; i++){
			for(int j=1; j<sideLen-1; j++) {
				current = input[i][j];
				if(current != 0) { // means that isn't adjacent to a hole
					left = input[i][j-1];
					right = input[i][j+1];
					above = input[i-1][j];
					below = input[i+1][j];
					if(current > left && current > right && current > above && current > below) {
						input[i][j] = 10; // it's a hole
						// mark the adjacent fields with 0s
						holes[i][j] = 0;
						holes[i][j-1] = 0;
						holes[i][j+1] = 0;
						holes[i-1][j] = 0;
						holes[i+1][j] = 0;
					}
				}
			}
			row = Arrays.toString(input[i]);
			row = row.replace("10", "X");
			row = row.replace(", ", "");
			row = row.replace("[", "");
			row = row.replace("]", "");
			ret[i] = row;
		}
		
		ret[0] = grid[0];
		ret[sideLen-1] = grid[sideLen-1];
		
		return ret;
    }
}
