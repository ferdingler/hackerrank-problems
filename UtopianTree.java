import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
* Problem URL: https://www.hackerrank.com/challenges/utopian-tree
*/

public class UtopianTree {
    
    static int getHeight(int cycles){
        int height = 1;
        for(int i=1; i<=cycles; i++){
            height += (i%2==0)? 1 : height;
        }
        return height;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(int i=0; i<t; i++){
            int cycles = in.nextInt();
            System.out.println(getHeight(cycles));
        }
    }
}