import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor
 */

public class IceCreamParlor {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){

            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }

            for(int i=0; i<n; i++){

                if(a[i] >= m){
                    continue;
                }

                boolean found = false;
                for(int j=0; j<n; j++){
                    if(i != j){
                        if(a[j] + a[i] == m){
                            System.out.println((i+1) + " " + (j+1));
                            found = true;
                            break;
                        }
                    }
                }

                if(found){
                    break;
                }
            }

        }
    }
}
