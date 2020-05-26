
public class ElectronicsShop {
	public static void main(String[] args) {
		System.out.println(getMoneySpent(new int[] {3,1}, new int[] {5,2,8}, 10)); // 9
		System.out.println(getMoneySpent(new int[] {4}, new int[] {5}, 5)); // -1
		
	}
	
	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int maxSpent = -1;
        int thisSpent;
        for (int keyboard : keyboards) {
        	thisSpent = 0;
        	for (int drive: drives) {
        		thisSpent = keyboard + drive <= b ? keyboard + drive : -1;
        		maxSpent = thisSpent > maxSpent ? thisSpent : maxSpent; 
        	}
        }
        return maxSpent;
    }
}
