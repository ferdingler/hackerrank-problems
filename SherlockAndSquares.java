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

    	for(int i=0; i<t; i++){
            
            long a = in.nextLong();
            long b = in.nextLong();
            int howMany = 0;
            
            for(Long n=a; n<=b; n++){
                if(Math.sqrt(n.doubleValue()) % 1 == 0)
                    howMany++;
            }
            
            System.out.println(howMany);
            
    	}
        
    }
}