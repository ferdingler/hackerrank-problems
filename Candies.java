import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Candies {

    // https://www.hackerrank.com/challenges/candies

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int grades[] = new int[n];
        int candies[] = new int[n];
        int totalCandies = 0;
        Queue<Integer> onHold = new LinkedList<Integer>();
        
        for(int i=0; i<n; i++){
            grades[i] = in.nextInt();
            onHold.add(i);
        }
        
        while(!onHold.isEmpty()){

            int i = onHold.poll();
            int leftNeighbor = -1;
            int rightNeighbor = -1;

            if(i < grades.length - 1){
                rightNeighbor = myNeighborCandies(i, i+1, grades, candies);
                if(rightNeighbor == -1){
                    onHold.add(i); continue;
                }
            }

            if(i > 0){
                leftNeighbor = myNeighborCandies(i, i-1, grades, candies);
                if(leftNeighbor == -1){
                    onHold.add(i); continue;
                }
            }
            
            candies[i] = Math.max(leftNeighbor, rightNeighbor) + 1; // biggest neighbor plus one
            totalCandies += candies[i];
        }
        
        System.out.println(totalCandies);
    }

    public static int myNeighborCandies(int i, int neighbor, int[] grades, int[] candies){
        if(grades[i] > grades[neighbor])
            return (candies[neighbor] == 0)? -1 : candies[neighbor];
        return 0;
    }       
}