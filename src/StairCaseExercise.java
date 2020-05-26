
public class StairCaseExercise {
	
	public static void main(String[] args) {
		int n=15;
		for(int i=n; i>=1; i--){
            for(int j=1; j<=n; j++){
                char character=j<i?' ':'#';
                System.out.print(character);
            }
            System.out.println();
        }
	}
}
