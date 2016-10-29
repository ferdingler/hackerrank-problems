import java.util.*;

/*
https://www.hackerrank.com/challenges/ctci-fibonacci-numbers
 */

public class Fibonacci {

    private static int fibonacci(int n) {

        if(n == 1){
            return 1;
        }

        if(n == 0){
            return 0;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
