
public class ViralAdvertising {
	static int viralAdvertising(int n) {
		int sent=5;
		int iterationLikes;
		int totalLikes=0;
		
		for(int i=0;i<n;i++) {
			iterationLikes=sent/2;
			totalLikes+=iterationLikes;
			sent=iterationLikes*3;
		}
		
		return totalLikes;
    }
	
	public static void main(String[] args) {
		System.out.println(viralAdvertising(3)); // expected 9
	}
}
