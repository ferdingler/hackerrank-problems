import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
* Problem URL: https://www.hackerrank.com/challenges/the-love-letter-mystery
*/

public class LoveLetterMystery {
    
    static int minOperationsToPalindrome(String str){
        
        char[] arr = str.toCharArray();
        int operations = 0;
        
        int i = 0; 
        int j = arr.length - 1;
        while(i < j){
            int target = ((int)arr[i] < (int)arr[j])? i : j;
            int greater = ((int)arr[i] < (int)arr[j])? j : i;
            while(arr[greater] != arr[target]){
                arr[greater] = reduceChar(arr[greater]);
                operations++;
            }
            i++; j--;
        }
        return operations;
    }
    
    static char reduceChar(char c){
        return (c == 'a')? 'a' : (char)(c - 1);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i<t; i++){
            System.out.println(minOperationsToPalindrome(in.next()));
        }
    }
}