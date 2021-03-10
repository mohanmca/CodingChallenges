package leedcode.greedy;

import code.challenge.AlgorithmUtils;

import java.util.Arrays;
import java.util.Collections;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
//        System.out.println(solution.coinChange(new int[]{5, 2, 1}, 11));
//        System.out.println(solution.coinChange(new int[]{5, 2}, 3));
//        System.out.println(solution.coinChange(new int[]{1}, 1));
//        System.out.println(solution.coinChange(new int[]{1}, 2));
        System.out.println(solution.coinChange(new int[]{186,419,83,408}, 6249));


    }

    public int coinChange(int[] coins, int amount) {
        //Ensure conins are sorted in desending order
        Arrays.sort(coins);
        int count = 0;
        int i = coins.length - 1;
        while (amount > 0) {
            if (i >= 0 && coins[i] <= amount) {
                amount -= coins[i];
                count++;
            } else if (i > 0) {
                i--;
            } else {
                break;
            }
        }
        return amount == 0 ? count : -1;
    }

}
