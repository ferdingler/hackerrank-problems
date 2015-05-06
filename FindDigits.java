import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Problem URL: https://www.hackerrank.com/challenges/find-digits
*/

public class FindDigits {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i<t; i++){
            long n = in.nextLong();
            long original = n;
            int count = 0;
            while(n > 0){
                long d = n % 10;
                if(d > 0 && original%d == 0)
                    count++;
                n = n / 10;
            }
            System.out.println(count);
        }
        
    }
}