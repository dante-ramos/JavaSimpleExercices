///https://www.hackerrank.com/challenges/acm-icpc-team/problem

public class ACM_ICPC_Team {

	public static void main(String[] args) {
		for(int result:acmTeam(new String[] {"10101", "11100", "11010", "00101"})) {
			System.out.println(result); // expected 5 and 2
		}
	}
	
	static int[] acmTeam(String[] topic) {
        String mostApt, lessApt; // to qualify the members
        int sumOfPair, maxSum = 0, countOfMax=0;
        
        for(int i=0;i<topic.length-1;i++)
            for(int j=i+1;j<topic.length;j++) {
                mostApt = topic[i].replaceAll("0", "").length() > topic[j].replaceAll("0", "" ).length() ? topic[i] : topic[j];
                lessApt = mostApt.equals(topic[i]) ? topic[j] : topic[i];
                
                sumOfPair = getSumOfPair(mostApt, lessApt, maxSum);
                
                if(sumOfPair==maxSum) {
                    countOfMax++;
                } else if(sumOfPair>maxSum) {
                    maxSum = sumOfPair;
                    countOfMax=1;
                }
            }
        return new int[] {maxSum,countOfMax};
    }

    static int getSumOfPair(String most, String less, int maxSum){
    	
        int sumOfOnes=0;
        int firstOne = most.indexOf("1") <= less.indexOf("1") ? most.indexOf("1") : less.indexOf("1");
        int lastOne = most.lastIndexOf("1") >= less.lastIndexOf("1") ? most.lastIndexOf("1") : less.lastIndexOf("1");
        
        for(int i=firstOne;i<=lastOne;i++) {
            if(most.charAt(i)=='1')
                sumOfOnes++;
            else if(less.charAt(i)=='1')
                sumOfOnes++;
            if(sumOfOnes + (most.length()-i) < maxSum)
            	return 0;
        }
        return sumOfOnes;
    }
}
