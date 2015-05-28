import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Problem URL: https://www.hackerrank.com/challenges/taum-and-bday
 */

public class TaumAndBday {

    public static void main(String[] args) {
        
    	Scanner in = new Scanner(System.in);
    	int t = in.nextInt();

    	for(int i=0; i<t; i++){

    		long b = in.nextLong();
    		long w = in.nextLong();
    		long x = in.nextLong();
    		long y = in.nextLong();
    		long z = in.nextLong();

    		long minBlackUnits = 0;
    		long minWhiteUnits = 0;

    		minBlackUnits = (x > y + z)? (y + z) * b : b * x;
    		minWhiteUnits = (y > x + z)? (x + z) * w : w * y;

    		System.out.println(minBlackUnits + minWhiteUnits);

    	}

    }
}