import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadCSVToArray {
	public static void main(String[] args) throws FileNotFoundException {
		String[][] result = new String[4][4];
		Scanner scann = new Scanner(new File ("/home/dante/eclipse-workspace/SeleniumCourseSelenium/src/performanceTestSystemWayDemo/DataToTest.csv"));
		String next = scann.nextLine();
		for(int i=0;i<4;i++) {
			System.out.println(next+" "+i);
			for (int j = 0;j<4;j++) {
				result[i][j] = next.split(",")[j];
				System.out.println(result[i][j] + " " + j + " - ");
			}
			next= scann.nextLine();
		}
		scann.close();
		System.out.println("++++ Leyendo el arreglo +++++");
		for (int i=0;i<4;i++) {
			for (int j=0; j<4;j++) {
				System.out.print(result[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
