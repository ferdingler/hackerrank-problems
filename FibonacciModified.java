import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/fibonacci-modified

public class FibonacciModified {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        BigInteger a = new BigInteger(in.next());
        BigInteger b = new BigInteger(in.next());
        int n = in.nextInt();

        BigInteger curr = new BigInteger("0");
        int nth = 3;
        
        while(nth++ <= n){
            curr = b.pow(2).add(a);
            a = b;
            b = curr;
        }
        
        System.out.println(curr);
        
    }
}