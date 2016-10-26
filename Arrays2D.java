import java.io.*;
import java.util.*;
import java.math.*;

/*
https://www.hackerrank.com/challenges/2d-array
 */

public class Arrays2D {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int matrix[][] = new int[6][6];

        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                matrix[i][j] = in.nextInt();
            }
        }

        List<int[]> hourGlasses = getHourGlasses(matrix);
        int max = hourGlasses.stream()
                .map((hourGlass) -> Arrays.stream(hourGlass).sum())
                .max(Comparator.naturalOrder())
                .get();

        System.out.println(max);
    }

    private static List<int[]> getHourGlasses(int[][] matrix){

        List<int[]> hourGlasses = new ArrayList<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                int[] hourGlass = getHourGlass(matrix, i, j);
                if(hourGlass != null){
                    hourGlasses.add(hourGlass);
                }
            }
        }

        return hourGlasses;
    }

    private static int[] getHourGlass(int[][] matrix, int i, int j){

        int n = matrix.length;
        if(i + 2 >= n){
            return null;
        }

        if(j + 2 >= n){
            return null;
        }

        return new int[]{
                matrix[i][j], matrix[i][j+1], matrix[i][j+2],
                                matrix[i+1][j+1],
                matrix[i+2][j], matrix[i+2][j+1], matrix[i+2][j+2] };
    }

}
