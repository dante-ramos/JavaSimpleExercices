
public class LisaWorkbook {

	public static void main(String[] args) {
		System.out.println(workbook(5, 3, new int[] {4, 2, 6, 1, 10})); // 4
	}
	
    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {
    	int occurrences = 0; // will count the occurrences of problem number equals to page number
    	int page = 0; // will handle the page number
    	int problemsTilPage; // will keep the las problem number in page
    	int problemsPrevPage; // will keep the last problem number in the last page
    	
    	for (int problemsPCharpter: arr) {
    		problemsTilPage = 0; // each chapter restart the problemsPPage values
    		problemsPrevPage = 0;
    		do { // while the problemsTilPage are not equal to the number of problems per charpter
    			problemsTilPage = Math.min(problemsTilPage+k, problemsPCharpter); // calculate the problemsTilPage, we use the min method because it's posible that it would be the last page of a chapter and it isn't filled with problems, so instead of having k problems may have less in that page
    			page++;
    			if(problemsTilPage>=page && page>problemsPrevPage) // if the page number is between the range of problems within the page
    				occurrences++;
    			problemsPrevPage+=k; // we increase the problems in the last page to take it into account in the next cicle
    		} while (problemsTilPage<problemsPCharpter);
    	}
    	
    	return occurrences;
    }
}
