
public class RoundingGrades {
	public static void main(String[] args) {
		int[] grades = { 4, 73, 67, 38, 33 };
		int grade;
		for (int i = 0; i < grades.length; i++) {
			grade = grades[i];
			if (grade > 37 && grade % 5 != 0 && grade % 5 >2 )
				grades[i] = ((grade / 5) + 1) * 5;
			System.out.print(grades[i] +" ");
		}
	}
}
