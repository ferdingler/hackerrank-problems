import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-bubble-sort
 */

public class BubbleSort {

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        int numberOfSwaps = 0;
        boolean sorted = true;

        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
        }

        // Bubble Sort
        do{

            sorted = true;
            for (int j=0; j<n-1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    numberOfSwaps++;
                    sorted = false;
                }
            }

        } while(!sorted);

        System.out.println("Array is sorted in " + numberOfSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }

    private static void swap(int[] a, int index1, int index2){
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

}
