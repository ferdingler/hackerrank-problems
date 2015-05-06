import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Problem URL: https://www.hackerrank.com/challenges/cut-the-sticks
*/

public class CutTheSticks {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] sticks = new int[n];
        
        for(int i=0; i<n; i++)
            sticks[i] = in.nextInt();
        
        Arrays.sort(sticks);

        boolean done = false;
        int startFrom = 0;
        while(!done){
            int smallest = sticks[startFrom];
            System.out.println(sticks.length - startFrom);
            for(int i=startFrom; i<sticks.length; i++){
                sticks[i] = sticks[i] - smallest;
                if(sticks[i] == 0) {
                    startFrom = i + 1;
                    done = (startFrom == sticks.length);
                }
            }
        }
    }
}