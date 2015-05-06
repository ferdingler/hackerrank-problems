import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Problem URL: https://www.hackerrank.com/challenges/cavity-map
*/

public class CavityMap {
    
    static boolean isCavity(int[][] map, int i, int j){
        int current = map[i][j]; 
        return (current > map[i][j-1] && current > map[i-1][j] && current > map[i+1][j] && current > map[i][j+1]);
    }

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] map = new int[n][n];
        
        // Build the matrix based on input
        for(int i=0; i<n; i++){
            char[] row = in.next().toCharArray();
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(String.valueOf(row[j]));
            }
        }
        
        // Do the calculations
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if((i > 0 && i < n - 1) && (j > 0 && j < n - 1)){
                    if(isCavity(map, i, j))
                        System.out.print("X");
                    else
                        System.out.print(map[i][j]);
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println("");           
        }
        
    }
}