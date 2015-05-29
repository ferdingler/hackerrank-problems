import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Problem URL: https://www.hackerrank.com/challenges/sherlock-and-squares
 */

public class SherlockAndSquares {

    public static void main(String[] args) {

    	Scanner in = new Scanner(System.in);
    	int t = in.nextInt();

    	int max = 1000000000;
    	int squareNumbers[] = new int[31624];
    	int i = 1; 
    	int n = 0;

    	do {
    		n = (int) Math.pow(i, 2);
    		squareNumbers[i++] = n;
    	} while(n < max);

    	for(int x=0; x<t; x++){
            
            int a = in.nextInt();
            int b = in.nextInt();
            int howMany = 0;

            for(int j=0; j<squareNumbers.length; j++){
            	if(squareNumbers[j] >= a && squareNumbers[j] <= b)
            		howMany++;
            }

            System.out.println(howMany);
            
    	}
        
    }
}