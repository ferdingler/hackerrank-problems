import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/ctci-lonely-integer
 */

public class LonelyInteger {

    private static int lonelyInteger(int[] a) {

        int[] counts = new int[100];
        for (int n : a) {
            counts[n] += 1;
        }

        for(int i=0; i<counts.length; i++){
            if(counts[i] == 1){
                return i;
            }
        }

        return a[0];
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
        }

        System.out.println(lonelyInteger(a));
    }
}
