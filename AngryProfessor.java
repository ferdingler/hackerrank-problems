import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Problem URL: https://www.hackerrank.com/challenges/angry-professor
*/

public class AngryProfessor {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(int i=0; i<t; i++){
            int n = in.nextInt();
            int k = in.nextInt();
            int onTime = 0;
            for(int j=0; j<n; j++)
                onTime += (in.nextInt() <= 0)? 1 : 0;
            System.out.println((onTime >= k)? "NO" : "YES");
        }
        
    }
}