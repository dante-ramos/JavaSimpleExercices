
public class ChocolateFeast {

	public static void main(String[] args) {
		System.out.println(chocolateFeast(10, 2, 5)); // 6
		System.out.println(chocolateFeast(14, 4, 4)); // 3
		System.out.println(chocolateFeast(6, 2, 2)); // 5

	}
	
    // Complete the chocolateFeast function below.
    static int chocolateFeast(int n, int c, int m) { // n = money c=cost m=wrappersNeeded
    	int totalChocolates = n/c; // will hold the total of chocolates, 0 if none can be bought
    	int wrappers = totalChocolates; // will hold the number of wrappers available;
    	int chocolatesPClicle; // will hold the number of chocolates get by cycle
    	while (wrappers>=m) { // while wrappers can be swapped for chocolates
    		chocolatesPClicle = wrappers/m; // how many chocolates given the wrappers
    		wrappers = wrappers%m + chocolatesPClicle; // wrappers left + the ones of the chocolates gotten
    		totalChocolates+=chocolatesPClicle; // adding the chocolates of the cycle to the total chocolates
    	}
    	return totalChocolates;
    }

}
