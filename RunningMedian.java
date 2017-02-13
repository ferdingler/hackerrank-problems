import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-find-the-running-median
 */
public class RunningMedian {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> a = new ArrayList<>();

        for(int i=0; i<n; i++){

            a.add(in.nextInt());
            a.sort(Integer::compareTo);

            double median;
            if(a.size() == 1){
                median = a.get(0);
            } else if(a.size() % 2 == 0){
                int half = a.size() / 2;
                median = (a.get(half) + a.get(half - 1)) / 2.0;
            } else {
                median = a.get(a.size() / 2);
            }

            System.out.println(round(median, 1));
        }

    }

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }



}
