import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/ctci-lonely-integer
 */

public class LonelyInteger {

    private static int lonelyInteger(int[] arr) {
        return Arrays.stream(arr).reduce(0, (int a, int b) -> a ^ b);
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
