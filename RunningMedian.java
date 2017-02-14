import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-find-the-running-median
 */
public class RunningMedian {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        double median = 0;
        for(int i=0; i<n; i++){

            int next = in.nextInt();
            if(next < median){
                if(max.size() - min.size() > 0){
                    min.add(max.poll());
                }
                max.add(next);
            } else {
                if(min.size() - max.size() > 0){
                    max.add(min.poll());
                }
                min.add(next);
            }

            if(max.size() > min.size()){
                median = max.peek();
            } else if(min.size() > max.size()){
                median = min.peek();
            } else {
                median = (max.peek() + min.peek()) / 2.0;
            }

            System.out.println(round(median, 1));
        }

    }

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
