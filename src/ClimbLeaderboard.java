public class ClimbLeaderboard {

	public static void main(String[] args) {
		for (int position : climbingLeaderboard(new int[] {100, 100, 50, 40, 40, 20, 10}, new int[] {5, 25, 50, 120}))
			System.out.println(position);
		System.out.println("\n");
		for (int position : climbingLeaderboard(new int[] {100, 90, 90, 80, 75, 60}, new int[] {50, 65, 77, 90, 102}))
			System.out.println(position);
	}
	
	static int[] climbingLeaderboard2(int[] scores, int[] alice) {
		int[]results = new int[alice.length];
		int position;
		int aliceScore;
		int nextScore;
		outerfor:
		for (int i=0; i<alice.length; i++) { // recorre el arreglo de scores de alice
			position = 1;
			aliceScore = alice[i];
			for (int j=0;j<scores.length;j++) { // recorre el arreglo de scores
				nextScore = j+1<scores.length ? scores[j+1] : 0;
				if(aliceScore>=scores[j]) {
					results[i] = position; // como se inicia con j = 1 evaluando con scores[j-1] el puesto obtenido es j
					continue outerfor; // se encontró el lugar de alice y se hace break al ciclo
				}
				else if(nextScore != scores[j])
					position++;
			}
			results[i] = position; // no se llegó a ningún break y por lo tanto alice tiene el último lugar
			
		}
		
		return results;
    }
	
	
	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		int[] results = new int[alice.length];
		int[] positions = getPositionsArray(scores); // gets a position array given a scores array, should have a final score 0 for the last position
		int pointer = scores.length-1; // will hold a pointer from back to front in the scores array (to make the script less slow)
		int actualScoreAlice;
		for (int i=0; i<alice.length; i++) {
			actualScoreAlice = alice[i];
			while (actualScoreAlice >= scores[pointer]) {
				if (pointer ==0)
					break;
				pointer--;
			}
			results[i] = actualScoreAlice>=scores[0] ? 1 : positions[pointer+1]; 
		}
		return results;
    }
	
	static int[] getPositionsArray(int[] scores) {
		int[] result = new int[scores.length+1];
		int position = 0;
		int lastScore = 0;
		for (int i=0;i<scores.length;i++) {
			if (scores[i]!=lastScore) {
				position++;
			}
			result[i] = position;
			lastScore = scores[i];
		}
		result[scores.length] = position +1;
		return result;
	}
}
