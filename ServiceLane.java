import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
* Problem URL: https://www.hackerrank.com/challenges/service-lane
*/

public class ServiceLane {
    
    static int getLargestVehicle(int i, int j, int[] width){
        int largest = 3;
        for(int x=i; x<=j; x++){
            largest = (width[x] < largest)? width[x] : largest;
        }
        return largest;
    }

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[] width = new int[n];
        
        for(int i=0; i<n; i++){
            width[i] = in.nextInt();
        }
        
        for(int x=0; x<t; x++){
            int i = in.nextInt();
            int j = in.nextInt();
            System.out.println(getLargestVehicle(i, j, width));
        }
        
    }
}