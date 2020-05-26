import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BonApetit {
	
	public static void main(String[] args) {
		List<Integer> lista = new ArrayList<>(5);
		lista.addAll(Arrays.asList(3,10,2,9));
		bonAppetit(lista, 1, 12);	
		bonAppetit(lista, 1, 7);	
	}
	
	static void bonAppetit(List<Integer> bill, int k, int b) {
		int suma=0;
		int promedio;
		for (int i=0;i<bill.size();i++) {
			suma+=i!=k ? bill.get(i) : 0;
		}
		promedio = suma/2;
		if(promedio == b)
			System.out.println("Bon Appetit");
		else
			System.out.println(Math.abs(promedio-b));

    } 
}
