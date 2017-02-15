import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/ctci-big-o
 */

public class Primality {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            System.out.println(isPrime(n)? "Prime" : "Not prime");
        }
    }

    private static boolean isPrime(int n){

        if(n == 1){
            return false;
        }

        int sqrt = (int) Math.sqrt((double) n);
        for(int i=2; i<=sqrt; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
