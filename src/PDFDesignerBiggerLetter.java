
public class PDFDesignerBiggerLetter {
	public static void main(String[] args) {
		System.out.println(designerPdfViewer(
				new int[] {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, 
				"abc"));
		
		System.out.println(designerPdfViewer(
				new int[] {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7}, 
				"zaba"));
	}
	
	static int designerPdfViewer(int[] h, String word) {
		String[] orderedAlphabet = "abcdefghijklmnopqrstuvwxyz".split("");
		orderArraysByLetterHeight(h, orderedAlphabet);
		
		for (int i=0;i<h.length;i++) {
			if (word.contains(orderedAlphabet[i]))
				return h[i]*word.length();
		}
		return 0;
    }
	
	static void orderArraysByLetterHeight(int[] heights, String[] letters) {
		int height;
		String letter;
		for (int i=1;i<heights.length;i++) {
			height = heights[i];
			letter = letters[i];
			for (int j=i-1;j>=0;j--) {
				if(heights[j]>=height) {
					heights[j+1] = height;
					letters[j+1] = letter;
					break;					
				}
				if(j!=0) {
					heights[j+1] = heights[j];
					letters[j+1] = letters[j];					
				}
				else {
					heights[1] = heights[0];
					letters[1] = letters[0];
					heights[0] = height;
					letters[0] = letter;
				}
			}
		}
	}
}
