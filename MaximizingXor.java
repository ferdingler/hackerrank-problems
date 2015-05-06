import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
* Problem URL: https://www.hackerrank.com/challenges/maximizing-xor
*/

public class MaximizingXor {

    static int maxXor(int l, int r) {
        int max = 0;
        for(int a=l; a<=r; a++){
            for(int b=a; b<=r; b++){
                int xor = a ^ b;
                max = (xor > max)? xor : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());
        
        int _r;
        _r = Integer.parseInt(in.nextLine());
        
        res = maxXor(_l, _r);
        System.out.println(res);
        
    }
}