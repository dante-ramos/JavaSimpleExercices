///https://www.hackerrank.com/challenges/acm-icpc-team/problem
public class ACP_ICPC_Team2 {
	public static void main(String[] args) {
		for(int result:acmTeam(new String[] {"10101", "11100", "11010", "00101"})) {
			System.out.println(result); // expected 5 and 2
		}
	}
	
	static int[] acmTeam(String[] topic) {
		int sumOfPair, maxSum = 0, countOfMax=0;
		
		for(int i=0;i<topic.length-1;i++)
			for(int j=i+1;j<topic.length;j++) {
				
				sumOfPair = getSumOfOnes(topic[i], topic[j]);
				if(sumOfPair==maxSum) {
					countOfMax++;
				} else if(sumOfPair>maxSum) {
					maxSum = sumOfPair;
					countOfMax=1;
				}
			}
		
		return new int[] {maxSum,countOfMax};
    }
	
	static int getSumOfOnes(String s1, String s2) {
		// operations to get the initial count of ones
		int startingIndex = s1.indexOf("1") >= s1.indexOf("1") ? 
				s1.indexOf("1") : s2.indexOf("1");
		int endingIndex = s1.lastIndexOf("1") <= s2.lastIndexOf("1") ? 
				s1.lastIndexOf("1") : s2.lastIndexOf("1");
		int onesAtTheLeft = s1.substring(0,startingIndex).replaceAll("0","").length() +
				s2.substring(0,startingIndex).replaceAll("0","").length();
		int onesAtTheRight = s1.substring(endingIndex+1, s1.length()).replaceAll("0", "").length() + 
				s2.substring(endingIndex+1, s1.length()).replaceAll("0", "").length();
		int sum = onesAtTheLeft + onesAtTheRight;
		
		// compare remaining strings
		int next0ins1, next0ins2;
		int next1ins1, next1ins2;
		for(int i=startingIndex;i<=endingIndex;i++) {
			if(s1.charAt(i+1)=='1' || s2.charAt(i+1)=='1') {
				next0ins1 = s1.substring(i,endingIndex).charAt('0');
				next0ins2 = s2.substring(i,endingIndex).charAt('0');
				if(next0ins1>next0ins2) {
					sum+=next0ins1 - i - 1;
					next1ins1 = s1.substring(next0ins1, endingIndex).charAt('1');
					next1ins2 = s2.substring(next0ins1, endingIndex).charAt('1');
					i= next1ins1 < next1ins2 ? next1ins1 : next1ins2;		
				} else {
					sum+=next0ins2 - i - 1;
					next1ins1 = s1.substring(next0ins2, endingIndex).charAt('1');
					next1ins2 = s2.substring(next0ins2, endingIndex).charAt('1');
				}
				i= next1ins1 < next1ins2 ? next1ins1 : next1ins2;
				
				sum+= next0ins1>next0ins2 ? next0ins1 - i : next0ins2 - i;
			} else {
				sum++;
				i = s2.substring(i+1, endingIndex).charAt('1');
			}
		}
		
		return sum;
	}
}
