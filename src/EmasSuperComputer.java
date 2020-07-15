import java.util.Arrays;
import java.util.stream.*;

/// https://www.hackerrank.com/challenges/two-pluses/problem
public class EmasSuperComputer {

    public static void main(String[] args) {
        // tests of mini grids
        // System.out.println(twoPluses(new String[]{"GB","BG"})); // 1
        // System.out.println(twoPluses(new String[]{"BB","BB"})); // 0
        // System.out.println(twoPluses(new String[]{"GG","GG"})); // 1
        // System.out.println(twoPluses(new String[]{"GB","BB"})); // 0

        // test of large grids
        System.out.println(twoPluses(new String[]{"GGGGGG","GBBBGB","GGGGGG","GGBBGB","GGGGGG"}));
        System.out.println(twoPluses(new String[]{"BGBBGB","GGGGGG","BGBBGB","GGGGGG","BGBBGB","BGBBGB"}));
        System.out.println(twoPluses(new String[]{"GGGGGGGG","GBGBGGBG","GBGBGGBG","GGGGGGGG","GBGBGGBG","GGGGGGGG","GBGBGGBG","GGGGGGGG"})); // exp 81
    }

    // Complete the twoPluses function below.
    static int twoPluses(String[] grid) {
        // the grestest lines or simetric crosses in the grid 
        int multiplication = 0;
        int greatest = 0;
        int[][] intGrid; // inputed grid but made bidimentional and with 0 intead of B and 1 instead of G
        int widht, height, wOdd, hOdd; // grid height, widht, heigth odd and width odd (eg: if height is 6, HOdd will be 5 which is the greater one segment result)
        int possibleCrossDiameter, possibleCrossStart;
        int numberOfGoods;

        // ;

        widht = grid[0].length(); // widht
        height = grid.length; // height
        numberOfGoods = String.join("", grid).replace("B", "").length();
        
        // no enough goods
        if( numberOfGoods == 2 )
            return 1;
        else if(numberOfGoods < 2)
            return 0;

        // mini grids
        if( widht < 3 && height < 3 ) // if widht and height are less than 3 only can be result 1 (because there's at least 2 goods)
            return  1;

        // ELSE there's a posibility of good segment result and ense a resulting product
        wOdd = (float)widht % 2 == 0 ? widht - 1 : widht; // gets the good segment width
        hOdd = (float)height % 2 == 0 ? height - 1 : height; // gets the good segment heigth
        possibleCrossDiameter = wOdd <= hOdd ? wOdd : hOdd;
        possibleCrossStart = possibleCrossDiameter * 2 - 1;
        
        // change G with 0s and B with 1 (we can then transform it to int[][] and apply sums to check presence of 1s)
        grid = Arrays.stream(grid).map(x -> x.replace("G","0").replace("B","1")).toArray(String[]::new); // weight to bad cells
        intGrid = Stream.of(grid).map(x -> Stream.of(x.split("")).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        
        multiplication = findGreatestMultiplication(possibleCrossStart, intGrid, greatest, multiplication);

        return multiplication;
    }

    static int findGreatestMultiplication(int possibleCross, int[][] intGrid, int greatest, int multiplication) {
        int crossMargin; // will hold the cross margin to the edges to the grid (while processing the crosses, this var is the number of cells that wont process, number of cells from the center to each cross arm (a 7 cell diameter cross, crossMargin will be the radius of 3))
        int height, widht;
        int[][] intGridCopy;

        widht = intGrid[0].length; // widht
        height = intGrid.length; // height

        mainWhile:
        while( possibleCross > 0) {
            crossMargin = (possibleCross + 1) / 2 / 2;
            for (int i = crossMargin ; i < height - crossMargin; i++) {
                checkHorizontally:
                for (int j = crossMargin; j < widht - crossMargin; j++) {
                    if( IntStream.of(Arrays.copyOfRange(intGrid[i], j-crossMargin, j+crossMargin+2)).sum() == 0 ) { // all the elements are 0 = Gs = goods
                        // check if also the other arm sums 0, if found a 1, breaks the search
                        for (int i2 = i-crossMargin ; i2 < i + crossMargin+1 ; i2++) if( intGrid[i2][j] == 1 ) continue checkHorizontally;
                        // if last line didn't jump to next cycle, all the elements vertical are 0s
                        if(greatest == 0) {
                            // set all the places as ones
                            intGridCopy = Stream.of(intGrid).map(x -> Arrays.copyOf(x, x.length)).toArray(int[][]::new); // copy of intGrid (can't use the clone or copyOf methods because is a bidimentional array)
                            for (int i2 = i-crossMargin ; i2 < i + crossMargin+1 ; i2++) intGridCopy[i2][j] = 1;
                            for (int j2 = j-crossMargin ; j2 < j + crossMargin+1 ; j2++) intGridCopy[i][j2] = 1;
                            if(possibleCross * possibleCross > multiplication)
                                multiplication = findGreatestMultiplication(possibleCross, intGridCopy, possibleCross, multiplication);
                        } 
                        else {
                            multiplication = greatest * possibleCross > multiplication ? greatest * possibleCross : multiplication;
                            break mainWhile;
                        }
                    }
                }
            }
            possibleCross -= 4;
        }
        return multiplication;
    }



    // static int twoPluses(String[] grid) {
    //     char[][] chars = new char[grid.length][grid[0].length()];
    //     int totalMaxResult = 1;
    //     for (int i = 0; i < chars.length; i++) {
    //         for (int j = 0; j < chars[0].length; j++) {
    //             int[] sizes = new int[]{1, 1};
    //             ArrayList<Integer[]> nodesMap = new ArrayList<>();
    //             for(int z = 0;z<grid.length;z++) {
    //                     chars[z] = grid[z].toCharArray();
    //                 }
    //             if (chars[i][j] != 'G') continue;
    //             nodesMap.add(new Integer[]{i,j});
    //             for (int s = 1; s < Math.min(chars.length, chars[0].length); s++) {
    //                     if(checkPlus(i, j, s, chars)) {
    //                         nodesMap.add(new Integer[]{i - s, j});
    //                         nodesMap.add(new Integer[]{i + s, j});
    //                         nodesMap.add(new Integer[]{i, j - s});
    //                         nodesMap.add(new Integer[]{i, j + s});
    //                         sizes[0]+=4;
    //                         nodesMap.forEach(v->chars[v[0]][v[1]] = 'O');
    //                     } else break;
    //                     for(int a = 0; a < chars.length; a++) {
    //                         for (int b = 0; b < chars[0].length; b++) {
    //                             if(chars[a][b] != 'G') continue;
    //                             totalMaxResult = Math.max(totalMaxResult,sizes[0]*sizes[1]);
    //                             for (int ss = 1; ss < Math.min(chars.length, chars[0].length); ss++) {
    //                                 if(checkPlus(a, b, ss, chars)) {
    //                                     sizes[1]+=4;
    //                                 } else break;
    //                                 totalMaxResult = Math.max(totalMaxResult,sizes[0]*sizes[1]);
    //                                 }
    //                             sizes[1] = 1;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return totalMaxResult;
    // }
    // private static boolean checkPlus(int i,int j,int k,char[][] chars) {

    //     if (i - k < 0 || (i - k >= 0 && chars[i - k][j] != 'G')) return false;
    //     if (i + k >= chars.length || (i + k < chars.length && chars[i + k][j] != 'G')) return false;
    //     if (j - k < 0 || (j - k >= 0 && chars[i][j - k] != 'G')) return false;
    //     if (j + k >= chars[0].length || (j + k < chars[0].length && chars[i][j + k] != 'G')) return false;

    //     return true;
    // }

}