import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Problem URL: https://www.hackerrank.com/challenges/manasa-and-stones
*/

public class ManasaStones {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(int i=0; i<t; i++){
         
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            int diff = max - min;
            
            if(a == b){
                System.out.println(min * (n - 1));
                continue;
            }
            
            min = min * (n - 1);
            max = max * (n - 1);
            int temp = min;
            
            while(temp <= max){
                System.out.print(temp + " ");
                temp += diff;
            }
            
            System.out.println("");
            
        }
    }
    
}