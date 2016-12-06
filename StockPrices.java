
public class StockPrices {

    /**
     * Given an array of stock prices, find the maximum profit you can make if you buy low on a day
     * and sell high on a future date. The array represents stock prices for each day.
     */

    public static void main(String args[]){
        System.out.println(maxProfit(new int[]{10, 10, 10, 10, 10}));
    }

    /**
     * Dynamic programming solution
     */
    public static int maxProfit(int[] prices){

        int len = prices.length;
        int[] maxes = new int[len];
        maxes[len-1] = prices[len-1];
        for(int i=len-2; i>=0; i--){
            maxes[i] = Math.max(maxes[i+1], prices[i]);
        }

        int maxProfit = 0;
        for(int i=0; i<len; i++){
            int profit = maxes[i] - prices[i];
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }

}
