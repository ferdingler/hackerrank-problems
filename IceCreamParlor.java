import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor
 */

public class IceCreamParlor {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){

            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }

            // We sort to dp binary search
            int[] sorted = a.clone();
            Arrays.sort(sorted);

            int cost1 = 0;
            int cost2 = 0;
            for(int i=n-1; i>=0; i--){
                if(sorted[i] < m){
                    int complement = m - sorted[i];
                    if(binarySearch(sorted, complement, 0, i-1)){
                        cost1 = sorted[i];
                        cost2 = complement;
                        break;
                    }
                }
            }

            int sunny = indexOf(a, cost1, -1);
            int johnny = indexOf(a, cost2, sunny);

            System.out.println((Math.min(sunny, johnny) + 1) + " " + (Math.max(sunny, johnny) + 1));
        }
    }

    private static int indexOf(int[] a, int num, int exclude){
        for(int i=0; i<a.length; i++){
            if(a[i] == num && i != exclude){
                return i;
            }
        }
        return -1;
    }

    private static boolean binarySearch(int[] arr, int num, int left, int right){

        int mid = ((right - left) / 2) + left;

        if(arr[mid] == num){
            return true;
        }

        if(left >= right){
            return false;
        }

        right = (arr[mid] > num)? mid - 1 : right;
        left = (arr[mid] < num)? mid + 1 : left;

        return binarySearch(arr, num, left, right);
    }

}
