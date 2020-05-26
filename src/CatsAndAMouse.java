
public class CatsAndAMouse {
	
	public static void main(String[] args) {
		System.out.println(catAndMouse(1, 2, 3));
		System.out.println(catAndMouse(1, 3, 2));
	}
	
	static String catAndMouse(int x, int y, int z) {
		String catAWins = "Cat A";
		String catBWins = "Cat B";
		String mouseWins = "Mouse C";
		int distanceCatA;
		int distanceCatB;
		distanceCatA = z - x;
		distanceCatB = z - y;
		if (z < x || z < y) {
			distanceCatA = Math.abs(distanceCatA);
			distanceCatB = Math.abs(distanceCatB);
		}
		if (distanceCatA == distanceCatB) return mouseWins;
		else if (distanceCatA < distanceCatB) return catAWins;
		return catBWins;
    }
}
