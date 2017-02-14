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
                balance(min, max);
                max.add(next);
            } else {
                balance(min, max);
                min.add(next);
            }

            median = getMedian(min, max);
            System.out.println(round(median, 1));
        }
    }

    private static double getMedian(Queue<Integer> min, Queue<Integer> max){

        if(max.size() > min.size()){
            return max.peek();
        }

        if(min.size() > max.size()){
            return min.peek();
        }

        return (max.peek() + min.peek()) / 2.0;
    }

    private static void balance(Queue<Integer> q1, Queue<Integer> q2){
        if(q1.size() - q2.size() > 0){
            q2.add(q1.poll());
        } else if(q2.size() - q1.size() > 0){
            q1.add(q2.poll());
        }
    }

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
