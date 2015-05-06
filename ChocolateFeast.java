import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Problem URL: https://www.hackerrank.com/challenges/chocolate-feast
*/

public class ChocolateFeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
        }
    }
    
    private static long Solve(int N, int C, int M){
        int chocolates = N / C;
        int wrapps = chocolates;
        int free = 0;
        while(wrapps >= M){
            free = wrapps/M;
            chocolates += free;
            wrapps = free + (wrapps%M);
        }
        return chocolates;
    }
    
    
}
