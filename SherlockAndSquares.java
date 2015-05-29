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

    	for(int x=0; x<t; x++){
            
            int a = in.nextInt();
            int b = in.nextInt();
            int howMany = 0;
            int n = 0;
            int i = 1;

            while(n <= b){
            	n = i * i;
            	if(n >= a && n <= b)
            		howMany++;
            	i++;
            }

            System.out.println(howMany);
            
    	}
        
    }
}