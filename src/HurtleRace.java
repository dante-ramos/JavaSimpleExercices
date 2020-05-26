import java.util.Arrays;

public class HurtleRace {

	public static void main(String[] args) {
		System.out.println(hurdleRace(4, new int[] {1, 6, 3, 5, 2})); // expected 2
		System.out.println(hurdleRace(7, new int[] {2, 5, 4, 5, 2})); // expected 0
	}

	static int hurdleRace(int k, int[] height) {
		Arrays.sort(height);
		int maxHurdleHeight = height[height.length-1];
		if (maxHurdleHeight>k)
			return maxHurdleHeight - k;
		return 0;
    }
}
