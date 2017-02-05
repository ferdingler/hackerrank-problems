import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/sock-merchant
 */

public class SockMerchant {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        int[] pairs = new int[100];

        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
            pairs[c[c_i] - 1] += 1;
        }

        int matchingPairs = 0;
        for (int pair : pairs) {
            if (pair > 0) {
                matchingPairs += pair / 2;
            }
        }

        System.out.println(matchingPairs);
    }
}

