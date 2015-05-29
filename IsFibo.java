import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Problem URL: https://www.hackerrank.com/challenges/is-fibo
 */

public class IsFibo {

    public static boolean isFibo(long n){
        
        long fibo = 1;
        long fibo1 = 1;
        long fibo2 = 0;
        
        while(fibo <= n){
            
            if(n == fibo)
                return true;

            fibo = fibo1 + fibo2;
            fibo2 = fibo1;
            fibo1 = fibo;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();    

        for(int i=0; i<t; i++){
            long n = in.nextLong();
            System.out.println(isFibo(n)? "IsFibo" : "IsNotFibo");
        }       
    }
}