package leedcode.array;

public class BuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{5,4,3,2,1}));
        System.out.println(maxProfit(new int[]{}));
        System.out.println(maxProfit(new int[]{1}));

    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int currentMinimum = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < currentMinimum) {
                currentMinimum = price;
            } else {
                profit = Math.max(profit, price - currentMinimum);
            }
        }
        return profit;
    }

}
