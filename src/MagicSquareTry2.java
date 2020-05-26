

public class MagicSquareTry2 {
	public static void main(String[] args) {
		//System.out.println(formingMagicSquare(new int[][]{{4,9,2},{3,5,7},{8,1,5}}));
		System.out.println(formingMagicSquare(new int[][]{{4,8,2},{4,5,7},{6,1,6}}));
	}
	
	static int formingMagicSquare(int[][] s) {
		int cost=0; // will contain the total weight given all the movements
		int[] sums=getSums(s);
		@SuppressWarnings("unused")
		int[][] needs; // will contain the needs per spot to complete a magic square
		int magicNumber = 15;
		while (checkmagic(sums,magicNumber)) {
			needs = getNeeds(sums, magicNumber);
			
		}
		
		return cost; 
    }
	
	static int[] getSums(int input[][]) {
		int[] result = new int[8]; // v1 starts [0][0], v2, v3, h1 starts [0][0], h2, h3, d1, d2 starts [0][0]
		for (int i=0;i<3;i++) {
			for (int j=0; j<3; j++) {
				result[j]+=input[i][j];
				result[i+3] += input[i][j];
				if(i==j) result[7]+=input[i][j];
				if(i+j==2) result[6]+=input[i][j];
			}
		}
		return result;
	}
	
	static boolean checkmagic(int input[], int magicNumber) {
		for(int item : input) if (item != magicNumber) return false;
		return true;
	}
	
	static int[][] getNeeds(int[] sums, int magicNumber){
		int[][] result = new int[3][3];
		for (int i=0; i<8; i++) {
			if(sums[i]==magicNumber)fillTheNeedsInLine(i, result);
			//
		}
		
		return result;
	}
	
	static void fillTheNeedsInLine(int i, int[][] result) {
		fillTheNeedsInLine(i, 0, result);
	}
	
	static void fillTheNeedsInLine(int i, int need, int[][] result) {
		int j; // para iteración de for
		if(i<3) {
			for(j=0;j<3;j++) result[j][i]=0;
		} else if (i>2 && i<6) {
			for(j=0;j<3;j++) result[i][j]=0;
		} else if (i==6) {
			for(j=0;j<3;j++) result[2-j][j]=0;
		} else { // i==7
			for(j=0;j<3;j++) result[j][j]=0;
		}
	}
}
