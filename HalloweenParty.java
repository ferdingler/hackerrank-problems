import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Problem URL: https://www.hackerrank.com/challenges/halloween-party
*/

public class HalloweenParty {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        for(int i=0; i<t; i++){
            long k = in.nextInt();
            long pieces = (k%2==0)? (k*k) / 4 : (k/2) * (k - (k/2));
            System.out.println(pieces);
        }
        
    }
}