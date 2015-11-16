import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/a-very-big-sum

public class AVeryBigSum {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long sum = 0;
        for(int i=0; i<n; i++)
            sum += in.nextInt();
        System.out.println(sum);
    }
}