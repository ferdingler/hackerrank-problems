import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Problem URL: https://www.hackerrank.com/challenges/funny-string
*/

public class FunnyString {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int i=0; i<t; i++){

            String S = in.next();
            String R = reverse(S);
            boolean funny = true;

            for(int j=1; j<S.length(); j++){
                int sDiff = (int) S.charAt(j) - (int) S.charAt(j - 1);
                int rDiff = (int) R.charAt(j) - (int) R.charAt(j - 1);
                if( Math.abs(sDiff) != Math.abs(rDiff) ){
                    funny = false;
                    break;
                }
            }

            System.out.println(funny? "Funny" : "Not Funny");
        }
        
    }

    private static String reverse(String S){

        int len = S.length();
        char reversed[] = new char[len];
        for(int i=len-1; i>=0; i--){
            reversed[len - i - 1] = S.charAt(i);
        }

        return new String(reversed);
    }
}