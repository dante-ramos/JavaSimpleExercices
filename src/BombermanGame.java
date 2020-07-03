// https://www.hackerrank.com/challenges/bomber-man/problem

import java.util.Arrays;
import java.util.stream.Stream;

public class BombermanGame {

	public static void main(String[] args) {
		String []array = new String[]{"...",".0.","..."};
		int seconds = 3;
		Arrays.stream(bomberMan(seconds, array)).forEach(System.out::println);
		
		System.out.println();
		array = new String[] {".......","...O...","....O..",".......","OO.....","OO....."};
		seconds = 3;
		Arrays.stream(bomberMan(seconds, array)).forEach(System.out::println);
		
		System.out.println();
		array = new String[] {".......","...O.O.","....O..","..O....","OO...OO","OO.O..."};
		seconds = 4;
		Arrays.stream(bomberMan(seconds, array)).forEach(System.out::println);
		
	}
	
	static String[] bomberMan(int n, String[] grid) {
		String[] result;
		String[] resultSec2;
		int seconds = n;
		
		int threePlus; //if seconds are 3 or greater we have to figure out which state of the cycle we need: 3sec, 3sec+1 or 3sec+2
		int state = 0; // for while cycle, until state <= threePlus 
		int [][]timersGrid; //will be a transformed version of the inputed string grid
		
		// init vars
		result = grid;
		resultSec2 = Stream.of(grid).map( x -> x.replace(".", "O")).toArray(String[]::new);
		
		// the game occurs in cycles of 4 after the 3 seconds, it means 3sec = 7sec, 4sec = 8sec, 5sec = 9sec and 6sec = 10sec
		// if seconds are less than 3, 1 will be the original grid and 2 will be one filled with bombs
		if( seconds<3 ) {
			if( seconds ==1 ) {
				// result is already equals to grid
			}
			else {
				result = resultSec2;
			}
		}
		// if seconds are 3 or greater we have to figure out which state of the cycle we need: 3sec, 3sec+1, 3sec+2 or 3sec+3
		else {
			threePlus = (seconds-3) % 4;
			// for the initial state or 3sec or state0, all the bombs has exploded leaving spaces
			// so we take the resultSec1 string array and map it to a bidimentional int array, but before replace bombs with timers in 1 and empty spaces with timer2
			result = Stream.of(grid).map( x -> x.replace(".", "2").replace("O", "1")).toArray(String[]::new);
			// iterate the states until it gets to the correct one
			while (state <= threePlus) {
				// even states are bomb explosion (add 0s around the current 0s)
				if( state % 2 == 0 ) {
					// 9 will be the bombs to explode
					result = Stream.of(result).map(x -> x.replace("1","9").replace("2","1")).toArray(String[]::new);
					// to int[][] to process bombs exploding
					timersGrid = Stream.of(result).map(x -> Stream.of(x.split("")).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
					for(int i=0 ; i < timersGrid.length ; i++){
						for(int j=0 ; j < timersGrid[0].length ; j++) {
							// there's a exploding bomb
							if( timersGrid[i][j] == 9 ) {
								if(i != 0)
									timersGrid[i-1][j] = timersGrid[i-1][j] == 9 ? 9 : 0;
								if( i != timersGrid.length-1 )
									timersGrid[i+1][j] = timersGrid[i+1][j] == 9 ? 9 : 0;
								if(j != 0)
									timersGrid[i][j-1] = timersGrid[i][j-1] == 9 ? 9 : 0;
								if(j != timersGrid[0].length -1 )
									timersGrid[i][j+1] = timersGrid[i][j+1] == 9 ? 9 : 0;
							}
						}
					}
					
					// again to string[] result
					result = Stream.of(timersGrid).map(x -> Arrays.toString(x).replace("[","").replace("]", "").replace(", ", "")).toArray(String[]::new);
					result = Stream.of(result).map(x -> x.replace("9","0")).toArray(String[]::new);
				}
				// odd states are bomb setting add 2s in the current 0s
				else {
					result = Stream.of(result).map(x -> x.replace("0","2")).toArray(String[]::new);
				}
				
				// go to next state
				state++;
			}
			
			// finally, convert the bidimentional int array to a single string array
			result = Stream.of(result).map(x -> x.replace("0",".").replace("1", "O").replace("2", "O")
					.replace("[","").replace("]", "").replace(", ", "")).toArray(String[]::new);
		}
		
		return result;
    }

}
