
public class MagicSwaureTry3 {
	public static void main(String[] args) {
//		System.out.println("First square: ");
//		System.out.println(formingMagicSquare(new int[][]{{4,9,2},{3,5,7},{8,1,5}}));
		
		System.out.println("Second square: ");
		System.out.println(formingMagicSquare(new int[][]{{4,8,2},{4,5,7},{6,1,6}}));
	}
	
	static int formingMagicSquare(int s[][]) {
		final int magicNumber=5;
		// init cost and set the center of the cube with 5 (the magicNumber)
		int cost = Math.abs(magicNumber-s[1][1]);
		s[1][1]=magicNumber;
		int[][] diferencesToMagic;
		// variables for some inner calculations
		int diference;
		int numberA;
		int numberB;
		int i=0;
		int rondas=0;
		do {
			System.out.println("Nuevo ciclo! " +i + " ronda número "+rondas);
			diferencesToMagic = fillDiferencesToMagic(s, magicNumber);
//			for(int i=0;i<4;i++) {
				if(diferencesToMagic[i][1]==1) {
					numberA = diferencesToMagic[i][0];
					numberB = diferencesToMagic[i+4][0];
					if(i!=0 && i%2.0!=0.0) { //debe ser par
						diference = Math.abs(Math.abs(numberA)-Math.abs(numberB));
						if(numberA%2==0 && numberB%2!=0 && numberA != 0) { // el segundo no fue par
							diferencesToMagic[i+4][0] = numberA*-1;
							cost +=diference;
						} else if (numberA%2!=0 && numberB%2==0 && numberB!=0) { //solo el primero no fue par
							diferencesToMagic[i][0] = numberB*-1;
							cost +=diference;
						} else {
							if (diferencesToMagic[i-1][1]==0 && diferencesToMagic[i+1][1]==0) {
								int complement= diferencesToMagic[i-1][1]+diferencesToMagic[i+1][1];
								diference = Math.abs(Math.abs(diferencesToMagic[i][0])-Math.abs(complement));
								cost+=diference;
								diferencesToMagic[i][0]=complement*-1;
							} else {
								if (diferencesToMagic[i+1][1]==0 && diferencesToMagic[i+2][1]==0) {
									int complement= diferencesToMagic[i+1][1]+diferencesToMagic[i+2][1];
									diference = Math.abs(Math.abs(diferencesToMagic[i][0])-Math.abs(complement));
									cost+=diference;
									diferencesToMagic[i][0]=complement*-1;
								}
								continue;
							}
						}
					} else { // es 0 o debe ser impar
						diference = Math.abs(Math.abs(numberA)-Math.abs(numberB));
						if(numberA%2!=0 &&numberB%2==0) { // el segundo no fue impar
							diferencesToMagic[i+4][0] = numberA*-1;
							cost +=diference;
						} else if (numberA%2==0 && numberB%2!=0) { //solo el primero fue par
							diferencesToMagic[i][0] = numberB*-1;
							cost +=diference;
						} else { // ninguno o ambos son impares
							if (diferencesToMagic[i+1][1]==0 && diferencesToMagic[i+2][1]==0) {
								int complement= diferencesToMagic[i+1][1]+diferencesToMagic[i+2][1];
								diference = Math.abs(Math.abs(diferencesToMagic[i][0])-Math.abs(complement));
								cost+=diference;
								diferencesToMagic[i][0]=complement*-1;
							}
						}
					}
				}
				System.out.println("Costo al momento:" +cost);
				applyChangestoCube(s,diferencesToMagic, magicNumber);
//			}
			i++;
			if (i>4) {
				i=0;
				System.out.println("Nueva ronda!!");
				rondas++;
				if(rondas>4) break;
			}
		}while(checkMagic(s)!=true);
		return cost;
	}
	
	static boolean checkMagic(int[][] input) {
		int[] result = new int[8];
		for (int i=0;i<3;i++) {
			for (int j=0; j<3; j++) {
				result[j]+=input[i][j];
				result[i+3] += input[i][j];
				if(i==j) result[7]+=input[i][j];
				if(i+j==2) result[6]+=input[i][j];
			}
		}
		for (int sum: result) {
			if(sum!=0) {
				System.out.println("No hay magia aún");
				return false;
			} 
		}
		System.out.println("Mágico!!!");
		return true;
	}
	
	static int[][] fillDiferencesToMagic(int[][] input, int magicNumber){
		int[][] result = new int[8][2];
		for(int i=0;i<8;i++) {
			if(i<3) result[i][0]=input[0][i]-magicNumber;
			else if (i<5) result[i][0]=input[i-2][2]-magicNumber;
			else if (i<7) result[i][0]=input[2][6-i]-magicNumber;
			else result[i][0]=input[1][0]-magicNumber; //i ==7
			result[i][1]=1;
		}
		for (int i=0;i<4;i++) {
			if(result[i][0]+result[i+4][0]==0 && result[i][0]!=0 && result[i+4][0]!=0) {
				result[i][1]=0;
				result[i+4][1]=0;
			} 
		}
		return result;
	}
	
	static void applyChangestoCube(int[][] s, int[][] diferencesToMagic, int magicNumber){
		int modifier;
		System.out.println();
		for(int i=0;i<8;i++) {
			System.out.print(diferencesToMagic[i][0]+" ");
			modifier = magicNumber+diferencesToMagic[i][0];
			if(i<3) s[0][i]=modifier;
			else if (i<5) s[i-2][2]=modifier;
			else if (i<7) s[2][6-i]=modifier;
			else s[1][0]=modifier; //i ==7
		}
		System.out.println();
	}
}
