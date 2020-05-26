import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QueensAttack {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(queensAttack(4, 0, 4, 4, null)); // exp 9
		System.out.println(queensAttack(5, 3, 4, 3, new int[][] {{5,5},{4,2},{2,3}})); // exp 10
		System.out.println(queensAttack(5, 3, 4, 3, new int[][] {{5,4},{4,2},{2,3}})); // exp 9
		System.out.println(queensAttack(1, 0, 1, 1, null)); // exp 0
		
		int[][] obstacles = readObstaclesFFile("/home/dante/eclipse-workspace/JavaSimpleExercices/src/QueensArrackT6.txt", 100);
		System.out.println(queensAttack(100, 100, 48, 81, obstacles)); // expected 40
	}

	/* 
- n: an integer, the number of rows and columns in the board 
- k: an integer, the number of obstacles on the board 
- r_q: integer, the row number of the queen's position 
- c_q: integer, the column number of the queen's position 
- obstacles: a two dimensional array of integers where each element is an array of  integers, the row and column of an obstacle
	 */
	
	static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) { // row, column
		int possibleAttacks = 0;
		int[] spotsPerDirection = purgeObstacles(n, r_q, c_q, obstacles); 
		for(int direction : spotsPerDirection)
			possibleAttacks+=direction;
		return possibleAttacks;
    }
	
	static int[] purgeObstacles(int boardLenght,int rowQ, int colQ, int[][] obstacles) {
		int row, column;
		int spots; // will hold the distance between queen and the obstacle
		int[] purged = new int[] {
				colQ-1,
				Math.min(rowQ, colQ)-1,
				rowQ-1,
				Math.min(rowQ-1, boardLenght-colQ),
				boardLenght-colQ,
				Math.min(boardLenght-rowQ, boardLenght-colQ),
				boardLenght-rowQ,
				Math.min(boardLenght-rowQ, colQ-1)
		};
		/* 
		 * 0: left, 
		 * 1: up left, 
		 * 2: up, 
		 * 3: up right, 
		 * 4: right, 
		 * 5:down right, 
		 * 6: down, 
		 * 7 down left
		 * */
		if (obstacles!=null) {
			for(int i=0;i<obstacles.length;i++) {
				row = obstacles[i][0];
				column = obstacles[i][1];
				
				if(row==rowQ) { // same row than the queen
					if (column<colQ) { // purged[0]
						spots = colQ-column-1;
						purged[0] = Math.min(purged[0], spots); // if purged[0] == -1 means that is the first obstacle found in that direction, if it isn't purged[0] will be the closest obstacle
					} else { // purged[4]
						spots = column-colQ-1;
						purged[4] = Math.min(purged[4], spots); 
					}
				} else if (column == colQ) { // same column than queen
					if(row<rowQ) { // purged [2]
						spots = rowQ-row-1;
						purged[2] = Math.min(purged[2], spots); 
					} else { // purged [6]
						spots = row-rowQ-1;
						purged[6] = Math.min(purged[6], spots); 
					}
				} else if (row < rowQ) { // up
					if(column < colQ) { // up left, purged [1]
						if(colQ-column == rowQ-row) {
							spots = colQ-column-1;
							purged[1] = Math.min(purged[1],spots);
						}
					} else { // up right, purged[3]
						if(column-colQ == rowQ-row) {
							spots = rowQ-row-1;
							purged[3] = Math.min(purged[3],spots);
						}
					}
				} else { // down
					if(column < colQ) { // down left, purged [7]
						if(colQ-column == row-rowQ) {
							spots = colQ-column-1;
							purged[7] = Math.min(purged[7], spots);
						}
					} else { // down right, purged[5]
						if(column-colQ == row-rowQ) {
							spots = column-colQ-1;
							purged[5] = Math.min(purged[5], spots);
						}
					}
				}
			}
		}
		return purged;
	}
	
	static int[][] readObstaclesFFile(String filePath, int lines) throws FileNotFoundException{
		int[][] result = new int[lines][2];
		String[] lineStrings = new String[2];
		Scanner scan = new Scanner(new File(filePath));
		
		int i=0;
		while(scan.hasNextLine()) {
			lineStrings=scan.nextLine().trim().split(" ");
			result[i][0]=Integer.parseInt(lineStrings[0]);
			result[i][1]=Integer.parseInt(lineStrings[1]);
			i++;
		}
		scan.close();
		
		return result;
	}
}
