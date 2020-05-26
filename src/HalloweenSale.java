
public class HalloweenSale {

	public static void main(String[] args) {
		System.out.println(howManyGames(20, 3, 6, 80)); // 6
		System.out.println(howManyGames(20, 3, 6, 85)); // 7

	}
	
    // Complete the howManyGames function below.
    static int howManyGames(int p, int d, int m, int s) {
        int games = 0; // will hold the count of games buyed
        int price = p; // will hold the price of games, starts with the price p, but it's modified given the bought games
        while (s-price>=0) { // while game can be bought given the calculated price
        	s-=price; 
        	games++;
        	price = price-d<=m ? m : price-d; // manage the price given the condition
        }
        return games;
    }

}
