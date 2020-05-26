import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BigDecimalProblem {
	public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here
        List<String> result = new LinkedList<>(); // will hold the result, we will take one element at a time of array s and put it sorted in this list
        BigDecimal currentNumber,listNumber; // will hold the number of s and listNumber will hold each of the numbers in result
        int pivot; // pointer of a inner iteration, will walk the result list
        
        result.add(s[0]); // the first element in s will be the first element in result; 
        
        outerLoop: // checkpoint to make a "continue" of a inner bucle
        for(int i=1;i<n;i++) {
            currentNumber = new BigDecimal(s[i]);
            for (pivot=0; pivot<result.size(); pivot++) {
                listNumber = new BigDecimal(result.get(pivot));
                if (listNumber.compareTo(currentNumber) == -1) { // -1 tells us that the listNumber is greater than the currentNumber
                    result.add(pivot, s[i]); // adds the number before the listNumber
                    continue outerLoop; // goes to the next iteration of outerLoop, it is, take the next number to put it sorted in result list
                }
            }
            result.add(s[i]); // if no number is greater than the currentNumber, puts it at the end of the result list
        }

        for(int i=0;i<n;i++) // passing the result to the array s
        {
            s[i] = result.get(i);
        }
            
        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
