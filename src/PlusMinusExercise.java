
public class PlusMinusExercise {

	public static void main(String[] args) {
		int[] arr = {-4, 3, -9, 0, 4, 1};
		int positives=0, negatives=0, zeros=0;
		Double size= (double) arr.length;
        for(int number: arr) {
            if(number>0) positives++;
            else if(number<0) negatives++;
            else zeros++;
        }
        System.out.println(positives/size);
        System.out.println(negatives/size);
        System.out.println(zeros/size);
	}
}
