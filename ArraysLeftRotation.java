import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArraysLeftRotation {

    private static int[] arrayLeftRotation(int[] a, int n, int d) {
        int[] rotated = new int[n];
        for(int i=0; i<n; i++){
            int newIndex = findNewIndex(i, n, d);
            rotated[newIndex] = a[i];
        }
        return rotated;
    }

    private static int findNewIndex(int currentIndex, int n, int d){
        int newIndex = currentIndex - d;
        return newIndex >= 0? newIndex : n + newIndex;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }
}
